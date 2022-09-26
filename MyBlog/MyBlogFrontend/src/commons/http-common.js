import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:1997/api",
    headers: {
        enctype:"multipart/form-data",
        "Content-type": false,
        processData: false,
    }
});