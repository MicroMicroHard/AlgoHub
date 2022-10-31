package HTTPConn

import "testing"

// HttpGet 基本的GET请求
func TestHttpGet(t *testing.T) {
	cli := RestHttpCli{}
	var url string = "https://www.hao123.com"
	cli.HttpGet(url)
}

func TestHttpGetWithParams(t *testing.T) {
	cli := RestHttpCli{}
	var url string = "http://www.baidu.com"
	paramsMap := make(map[string]string)
	paramsMap["name"] = "zhangsan"
	paramsMap["age"] = "lisi"
	cli.HttpGetWithParams(url, paramsMap)
}
