let getters = {
    completed(state) {
        return state.todos.filter(e => e.isCompleted === true);
    },
    remaining(state) {
        return state.todos.filter((e => e.isCompleted === false));
    }
}

export default getters