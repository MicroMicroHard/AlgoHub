package HTTPConn

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"net/url"
)

type RestHttpCli struct {
}

// HttpGet 基本的GET请求
func (h *RestHttpCli) HttpGet(urlPath string) {
	resp, err := http.Get(urlPath)
	if err != nil {
		fmt.Println(err)
		return
	}
	defer resp.Body.Close()
	_, err = ioutil.ReadAll(resp.Body)
	/*fmt.Println(string(body))
	fmt.Println(resp.StatusCode)*/
	if resp.StatusCode == 200 {
		fmt.Println("ok")
	}
}

func (h *RestHttpCli) HttpGetWithParams(urlStr string, paramsMap map[string]string) {
	params := url.Values{}
	Url, err := url.Parse(urlStr)
	if err != nil {
		return
	}
	for k, v := range paramsMap {
		params.Set(k, v)
	}
	//如果参数中有中文参数,这个方法会进行URLEncode
	Url.RawQuery = params.Encode()
	urlPath := Url.String()
	fmt.Println(urlPath) // https://www.baidu.com?age=26&name=Paul_chan
	resp, err := http.Get(urlPath)
	defer resp.Body.Close()
	body, _ := ioutil.ReadAll(resp.Body)
	fmt.Println(string(body))
}
