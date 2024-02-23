import request from "../utils/request";

export function queryFacilities() {
  return request.get("/gourmet/facilities");
}
