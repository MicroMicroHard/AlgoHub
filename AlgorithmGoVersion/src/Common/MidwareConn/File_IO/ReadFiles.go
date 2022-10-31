package File_IO

import "os"

// file grammar : 读取文件

type Files struct {
}

func ReadTxtFiles(filePath string) string {
	content, err := os.ReadFile(filePath)
	if err != nil {
		panic(err)
	}
	return string(content)
}
