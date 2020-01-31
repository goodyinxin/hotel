//插件模块
import axios from 'axios'
const HttpServer={};
HttpServer.install=(Vue)=>{
  axios.defaults.baseURL='http://localhost:80';
  axios.defaults.withCredentials = true;


  /*拦截器*/
  // 添加请求拦截器
  axios.interceptors.request.use(function (config) {
    // 在发送请求之前做些什么
    console.log('url===>',config.url)
    if(config.url !== '/user/login'){
      const AUTH_TOKEN =localStorage.getItem('token');
      //this.$http.defaults.headers.common['AUTH_TOKEN'] =AUTH_TOKEN;
      config.headers['AUTH_TOKEN'] =AUTH_TOKEN
    }

    return config;
  }, function (error) {
    // 对请求错误做些什么
    return Promise.reject(error);
  });

// 添加响应拦截器
  axios.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response;
  }, function (error) {
    // 对响应错误做点什么
    return Promise.reject(error);
  });


  Vue.prototype.$http=axios
}
export default HttpServer
