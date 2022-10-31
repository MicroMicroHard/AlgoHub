package Utils

// BeanUtils
// @author: 蔚蔚樱
// @date: 2022/8/210:35
// @author—Email: micromicrohard@outlook.com
// @description: 用于存放一些Bean
// @blogURL:

// AlertEntity 监控项
type AlertEntity struct {
	RuleId           string            `json:"rule_id"`
	ProjectName      string            `json:"project_name"`
	MetricStoreNames [][]string        `json:"metric_store_names"`
	RuleLabelOrg     string            `json:"rule_label_org"`
	AlertRuleContent AlertRuleContent  `json:"alert_rule_content"`
	AlertRuleLabels  map[string]string `json:"alert_rule_labels"`
	RuleType         string            `json:"rule_type"`
	DisplayName      string            `json:"display_name"`
	GrafanaUrl       string            `json:"grafana_url"`
	IsDisabled       int               `json:"is_disabled"`
	Creator          string            `json:"creator"`
	Updater          string            `json:"updater"`
	CreateTime       string            `json:"create_time"`
	UpdateTime       string            `json:"update_time"`
}

type AlertRuleContent struct {
	Content  Content `json:"content"`
	Severity string  `json:"severity"`
}

type Content struct {
	For                       string          `json:"for"`
	Expr                      string          `json:"expr"`
	MessageTemplate           MessageTemplate `json:"message_template"`
	EvaluationInterval        string          `json:"evaluation_interval"`
	BuiltInEvaluationInterval string          `json:"built_in_evaluation_interval"`
}

type MessageTemplate struct {
	FiringMessage   string `json:"firing_message"`
	ResolvedMessage string `json:"resolved_message"`
}
