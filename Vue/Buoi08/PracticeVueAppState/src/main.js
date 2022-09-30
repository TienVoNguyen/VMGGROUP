import Vue from 'vue';
import App from './App.vue';
// import router from './commons/router';
import ElementUI from 'element-ui';
import locale from 'element-ui/lib/locale/lang/en';
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue';
import index from './store/index';
import 'element-ui/lib/theme-chalk/index.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
// import index from "vuex";

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);
Vue.use(ElementUI, { locale });
Vue.config.productionTip = false;

new Vue({
  store: index,
  render: h => h(App),
}).$mount('#app')
