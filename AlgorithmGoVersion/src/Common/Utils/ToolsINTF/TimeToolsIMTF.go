package ToolsINTF

import "time"

/**
 * @author 蔚蔚樱
 * @version V1.0
 * @date 2022/10/11 23:25
 * @author-Email micromicrohard@outlook.com
 * @description
 */
type TimeToolsIMTF interface {
	TimeStampGap(currentTime time.Time, params string) time.Time // 获取params间隔之后的时间戳
	GetBeforeDawnTimeStamp() int64                               // 获取当天0点 的时间戳
	GetWeekDay() int64                                           // 今天是周几
}
