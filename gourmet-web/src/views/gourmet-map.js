/* global google */
import * as React from "react";
import { useEffect, useState, useRef } from "react";
import "./gourmet-map.css";
import { queryFacilities } from "../api/gourmet";
import loader from "../utils/google-map";

export default function GourmetMap() {
  const mapRef = useRef(null);
  const [map, setMap] = useState(null);
  const [facilities, setFacilites] = useState([]);
  const [infoWindow, setInfoWindow] = useState(undefined);

  async function initMap() {
    if (!mapRef.current || map) {
      return;
    }
    loader.importLibrary("maps").then(({ Map }) => {
      const initializedMap = new Map(mapRef.current, {
        center: { lat: 37.7929489528347, lng: -122.398098613167 },
        zoom: 16,
        mapId: "b10d584a0c64aac3",
      });
      setMap(initializedMap);
    });
  }

  useEffect(() => {
    initMap();
  }, [mapRef, map]);

  useEffect(() => {
    console.log("init infoWindow");
    if (infoWindow) {
      return;
    }
    const init = async () => {
      const { InfoWindow } = await loader.importLibrary("maps");
      const infoWindow = new InfoWindow({});
      setInfoWindow(infoWindow);
    };
    init();
  }, [infoWindow]);

  useEffect(() => {
    if (!map) {
      return;
    }
    queryFacilities().then(async (res) => {
      setFacilites(res?.data || []);
      if (res?.data) {
        for (let i = 0; i < res.data.length; i++) {
          const item = res.data[i];
          const { Size } = await loader.importLibrary("maps");
          const { Marker } = await loader.importLibrary("marker");
          const marker = new Marker({
            position: { lat: item.latitude, lng: item.longitude },
            map,
            title: item.applicant,
          });
          marker.addListener("click", async (event) => {
            console.log("click", event);
            infoWindow.close();
            infoWindow.setContent(`
            <div>
            Applicant: ${item.applicant}<br/>
            Cnn: ${item.cnn}<br/>
            Permit: ${item.permit}<br/>
            ZipCodes: ${item.zipCodes}<br/>
            Address: ${item.address}<br/>
            LocationDescription: ${item.locationDescription}<br/>
            FoodItems: ${item.foodItems}<br/>
            </div>
            `);
            infoWindow.open(marker.map, marker);
          });
        }
      }
    });
  }, [map]);

  return (
    <div className="page">
      <div ref={mapRef} style={{ height: "100%", width: "100%" }} />
    </div>
  );
}
