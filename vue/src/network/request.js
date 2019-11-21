import axios from 'axios'

export function request(config){
	//1.创建axios实例
	const instance = axios.create({
		timeout: 5000
	})

	//2.axios拦截器

	//2.1请求拦截的作用
	instance.interceptors.request.use(config => {
		return config
	}, err => {

	})
  
  //2.响应拦截
	instance.interceptors.response.use(res => {
		return res.data
	}, err => {
		console.log(err);
	})

	//3.发送真正的网络请求 返回的是Promise 可通过then方法调用
	return instance(config)
}