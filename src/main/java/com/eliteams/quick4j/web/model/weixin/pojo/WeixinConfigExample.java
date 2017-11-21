package com.eliteams.quick4j.web.model.weixin.pojo;

import java.util.ArrayList;
import java.util.List;

public class WeixinConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WeixinConfigExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWxTokenIsNull() {
            addCriterion("wx_token is null");
            return (Criteria) this;
        }

        public Criteria andWxTokenIsNotNull() {
            addCriterion("wx_token is not null");
            return (Criteria) this;
        }

        public Criteria andWxTokenEqualTo(String value) {
            addCriterion("wx_token =", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenNotEqualTo(String value) {
            addCriterion("wx_token <>", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenGreaterThan(String value) {
            addCriterion("wx_token >", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenGreaterThanOrEqualTo(String value) {
            addCriterion("wx_token >=", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenLessThan(String value) {
            addCriterion("wx_token <", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenLessThanOrEqualTo(String value) {
            addCriterion("wx_token <=", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenLike(String value) {
            addCriterion("wx_token like", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenNotLike(String value) {
            addCriterion("wx_token not like", value, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenIn(List<String> values) {
            addCriterion("wx_token in", values, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenNotIn(List<String> values) {
            addCriterion("wx_token not in", values, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenBetween(String value1, String value2) {
            addCriterion("wx_token between", value1, value2, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxTokenNotBetween(String value1, String value2) {
            addCriterion("wx_token not between", value1, value2, "wxToken");
            return (Criteria) this;
        }

        public Criteria andWxAppidIsNull() {
            addCriterion("wx_appID is null");
            return (Criteria) this;
        }

        public Criteria andWxAppidIsNotNull() {
            addCriterion("wx_appID is not null");
            return (Criteria) this;
        }

        public Criteria andWxAppidEqualTo(String value) {
            addCriterion("wx_appID =", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotEqualTo(String value) {
            addCriterion("wx_appID <>", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidGreaterThan(String value) {
            addCriterion("wx_appID >", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidGreaterThanOrEqualTo(String value) {
            addCriterion("wx_appID >=", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidLessThan(String value) {
            addCriterion("wx_appID <", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidLessThanOrEqualTo(String value) {
            addCriterion("wx_appID <=", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidLike(String value) {
            addCriterion("wx_appID like", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotLike(String value) {
            addCriterion("wx_appID not like", value, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidIn(List<String> values) {
            addCriterion("wx_appID in", values, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotIn(List<String> values) {
            addCriterion("wx_appID not in", values, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidBetween(String value1, String value2) {
            addCriterion("wx_appID between", value1, value2, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxAppidNotBetween(String value1, String value2) {
            addCriterion("wx_appID not between", value1, value2, "wxAppid");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyIsNull() {
            addCriterion("wx_encodingAesKey is null");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyIsNotNull() {
            addCriterion("wx_encodingAesKey is not null");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyEqualTo(String value) {
            addCriterion("wx_encodingAesKey =", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyNotEqualTo(String value) {
            addCriterion("wx_encodingAesKey <>", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyGreaterThan(String value) {
            addCriterion("wx_encodingAesKey >", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyGreaterThanOrEqualTo(String value) {
            addCriterion("wx_encodingAesKey >=", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyLessThan(String value) {
            addCriterion("wx_encodingAesKey <", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyLessThanOrEqualTo(String value) {
            addCriterion("wx_encodingAesKey <=", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyLike(String value) {
            addCriterion("wx_encodingAesKey like", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyNotLike(String value) {
            addCriterion("wx_encodingAesKey not like", value, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyIn(List<String> values) {
            addCriterion("wx_encodingAesKey in", values, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyNotIn(List<String> values) {
            addCriterion("wx_encodingAesKey not in", values, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyBetween(String value1, String value2) {
            addCriterion("wx_encodingAesKey between", value1, value2, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxEncodingaeskeyNotBetween(String value1, String value2) {
            addCriterion("wx_encodingAesKey not between", value1, value2, "wxEncodingaeskey");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenIsNull() {
            addCriterion("wx_access_token is null");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenIsNotNull() {
            addCriterion("wx_access_token is not null");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenEqualTo(String value) {
            addCriterion("wx_access_token =", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotEqualTo(String value) {
            addCriterion("wx_access_token <>", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenGreaterThan(String value) {
            addCriterion("wx_access_token >", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenGreaterThanOrEqualTo(String value) {
            addCriterion("wx_access_token >=", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenLessThan(String value) {
            addCriterion("wx_access_token <", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenLessThanOrEqualTo(String value) {
            addCriterion("wx_access_token <=", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenLike(String value) {
            addCriterion("wx_access_token like", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotLike(String value) {
            addCriterion("wx_access_token not like", value, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenIn(List<String> values) {
            addCriterion("wx_access_token in", values, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotIn(List<String> values) {
            addCriterion("wx_access_token not in", values, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenBetween(String value1, String value2) {
            addCriterion("wx_access_token between", value1, value2, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxAccessTokenNotBetween(String value1, String value2) {
            addCriterion("wx_access_token not between", value1, value2, "wxAccessToken");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlIsNull() {
            addCriterion("wx_project_url is null");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlIsNotNull() {
            addCriterion("wx_project_url is not null");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlEqualTo(String value) {
            addCriterion("wx_project_url =", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlNotEqualTo(String value) {
            addCriterion("wx_project_url <>", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlGreaterThan(String value) {
            addCriterion("wx_project_url >", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlGreaterThanOrEqualTo(String value) {
            addCriterion("wx_project_url >=", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlLessThan(String value) {
            addCriterion("wx_project_url <", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlLessThanOrEqualTo(String value) {
            addCriterion("wx_project_url <=", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlLike(String value) {
            addCriterion("wx_project_url like", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlNotLike(String value) {
            addCriterion("wx_project_url not like", value, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlIn(List<String> values) {
            addCriterion("wx_project_url in", values, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlNotIn(List<String> values) {
            addCriterion("wx_project_url not in", values, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlBetween(String value1, String value2) {
            addCriterion("wx_project_url between", value1, value2, "wxProjectUrl");
            return (Criteria) this;
        }

        public Criteria andWxProjectUrlNotBetween(String value1, String value2) {
            addCriterion("wx_project_url not between", value1, value2, "wxProjectUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}