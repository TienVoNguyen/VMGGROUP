import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:1997/api",
  headers: {
    "Content-type": "application/json"
  }
});