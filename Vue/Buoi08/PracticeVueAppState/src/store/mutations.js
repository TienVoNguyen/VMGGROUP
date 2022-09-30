// src/store/mutations.js
import * as types from '@/mutation-type'

let mutations = {
    [types.ADD_NEW_TODO](state, payload) {
        let newTodo = {content: payload, isCompleted: false};
        state.todos.push(newTodo);
    },
    [types.TOGGLE_STATUS](state, payload) {
        let todo = payload
        todo.isCompleted = !todo.isCompleted
    },
    [types.DELETE_TODO](state, payload) {
        state.todos.splice(state.todos.indexOf(payload), 1);
    }
}

export default mutations