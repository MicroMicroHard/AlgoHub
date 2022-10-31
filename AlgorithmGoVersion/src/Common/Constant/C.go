package C

const (
	ProjectName   = "AlgorithmGoVersion"
	Min           = 0
	Max           = 1000000
	ErrorNum      = -999
	QuotationMark = "\"" //引号
)
const (
	MaxInt8   = 1<<7 - 1
	MinInt8   = -1 << 7
	MaxInt16  = 1<<15 - 1
	MinInt16  = -1 << 15
	MaxInt32  = 1<<31 - 1
	MinInt32  = -1 << 31
	MaxInt64  = 1<<63 - 1
	MinInt64  = -1 << 63
	MaxUint8  = 1<<8 - 1
	MaxUint16 = 1<<16 - 1
	MaxUint32 = 1<<32 - 1
	MaxUint64 = 1<<64 - 1
)

type ScoreRequestType int

const (
	zeroNum ScoreRequestType = iota // attention iota是从0开始的，不是1
	OneWayBill2ManyDriver
	OneDriver2ManyWayBill
)

const (
	A = 0.0
)
