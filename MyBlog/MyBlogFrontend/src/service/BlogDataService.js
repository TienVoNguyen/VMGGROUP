import http from "../commons/http-common";

class TodoDataService {
    getAll() {
        return http.get("/blogList");
    }

    get(id) {
        return http.get(`/todo/${id}`);
    }

    create(data) {
        let fromData = new FormData(data);
        console.log(fromData);
        return http.post("/create", fromData);
    }

    update(id, data) {
        return http.put(`/update/${id}`, data);
    }

    delete(id) {
        return http.delete(`/delete/${id}`);
    }

    deleteAll() {
        return http.delete(`/todo`);
    }

    findByTitle(title) {
        return http.get(`/todo?title=${title}`);
    }
}

export default new TodoDataService();