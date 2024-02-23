import { Loader } from "@googlemaps/js-api-loader";

const additionalOptions = {};
const loader = new Loader({
  apiKey: "AIzaSyC9E-QWuNTtT58DiPPC_QeADbMpuUz9ZzU",
  version: "weekly",
  ...additionalOptions,
});

export default loader;
