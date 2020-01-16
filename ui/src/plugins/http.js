//插件模块
import axios from 'axios'
const HttpServer={};
HttpServer.install=(Vue)=>{
  axios.defaults.baseURL='http://localhost:80';
  axios.defaults.withCredentials = true;
  Vue.prototype.$http=axios
}
export default HttpServer
