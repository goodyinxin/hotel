//插件模块
import axios from 'axios'
const HttpServer={};
HttpServer.install=(Vue)=>{
  axios.defaults.baseURL='http://localhost:80'

  Vue.prototype.$http=axios
}
export default HttpServer
