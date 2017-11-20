package com.eliteams.quick4j.web.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivitExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeIsNull() {
            addCriterion("activitystarttime is null");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeIsNotNull() {
            addCriterion("activitystarttime is not null");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeEqualTo(Date value) {
            addCriterion("activitystarttime =", value, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeNotEqualTo(Date value) {
            addCriterion("activitystarttime <>", value, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeGreaterThan(Date value) {
            addCriterion("activitystarttime >", value, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activitystarttime >=", value, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeLessThan(Date value) {
            addCriterion("activitystarttime <", value, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeLessThanOrEqualTo(Date value) {
            addCriterion("activitystarttime <=", value, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeIn(List<Date> values) {
            addCriterion("activitystarttime in", values, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeNotIn(List<Date> values) {
            addCriterion("activitystarttime not in", values, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeBetween(Date value1, Date value2) {
            addCriterion("activitystarttime between", value1, value2, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivitystarttimeNotBetween(Date value1, Date value2) {
            addCriterion("activitystarttime not between", value1, value2, "activitystarttime");
            return (Criteria) this;
        }

        public Criteria andActivityimgIsNull() {
            addCriterion("activityimg is null");
            return (Criteria) this;
        }

        public Criteria andActivityimgIsNotNull() {
            addCriterion("activityimg is not null");
            return (Criteria) this;
        }

        public Criteria andActivityimgEqualTo(String value) {
            addCriterion("activityimg =", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgNotEqualTo(String value) {
            addCriterion("activityimg <>", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgGreaterThan(String value) {
            addCriterion("activityimg >", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgGreaterThanOrEqualTo(String value) {
            addCriterion("activityimg >=", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgLessThan(String value) {
            addCriterion("activityimg <", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgLessThanOrEqualTo(String value) {
            addCriterion("activityimg <=", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgLike(String value) {
            addCriterion("activityimg like", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgNotLike(String value) {
            addCriterion("activityimg not like", value, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgIn(List<String> values) {
            addCriterion("activityimg in", values, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgNotIn(List<String> values) {
            addCriterion("activityimg not in", values, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgBetween(String value1, String value2) {
            addCriterion("activityimg between", value1, value2, "activityimg");
            return (Criteria) this;
        }

        public Criteria andActivityimgNotBetween(String value1, String value2) {
            addCriterion("activityimg not between", value1, value2, "activityimg");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNull() {
            addCriterion("videourl is null");
            return (Criteria) this;
        }

        public Criteria andVideourlIsNotNull() {
            addCriterion("videourl is not null");
            return (Criteria) this;
        }

        public Criteria andVideourlEqualTo(String value) {
            addCriterion("videourl =", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotEqualTo(String value) {
            addCriterion("videourl <>", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThan(String value) {
            addCriterion("videourl >", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlGreaterThanOrEqualTo(String value) {
            addCriterion("videourl >=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThan(String value) {
            addCriterion("videourl <", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLessThanOrEqualTo(String value) {
            addCriterion("videourl <=", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlLike(String value) {
            addCriterion("videourl like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotLike(String value) {
            addCriterion("videourl not like", value, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlIn(List<String> values) {
            addCriterion("videourl in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotIn(List<String> values) {
            addCriterion("videourl not in", values, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlBetween(String value1, String value2) {
            addCriterion("videourl between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andVideourlNotBetween(String value1, String value2) {
            addCriterion("videourl not between", value1, value2, "videourl");
            return (Criteria) this;
        }

        public Criteria andIsactivityIsNull() {
            addCriterion("isactivity is null");
            return (Criteria) this;
        }

        public Criteria andIsactivityIsNotNull() {
            addCriterion("isactivity is not null");
            return (Criteria) this;
        }

        public Criteria andIsactivityEqualTo(Integer value) {
            addCriterion("isactivity =", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityNotEqualTo(Integer value) {
            addCriterion("isactivity <>", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityGreaterThan(Integer value) {
            addCriterion("isactivity >", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityGreaterThanOrEqualTo(Integer value) {
            addCriterion("isactivity >=", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityLessThan(Integer value) {
            addCriterion("isactivity <", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityLessThanOrEqualTo(Integer value) {
            addCriterion("isactivity <=", value, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityIn(List<Integer> values) {
            addCriterion("isactivity in", values, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityNotIn(List<Integer> values) {
            addCriterion("isactivity not in", values, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityBetween(Integer value1, Integer value2) {
            addCriterion("isactivity between", value1, value2, "isactivity");
            return (Criteria) this;
        }

        public Criteria andIsactivityNotBetween(Integer value1, Integer value2) {
            addCriterion("isactivity not between", value1, value2, "isactivity");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("proid is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proid is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(String value) {
            addCriterion("proid =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(String value) {
            addCriterion("proid <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(String value) {
            addCriterion("proid >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(String value) {
            addCriterion("proid >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(String value) {
            addCriterion("proid <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(String value) {
            addCriterion("proid <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLike(String value) {
            addCriterion("proid like", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotLike(String value) {
            addCriterion("proid not like", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<String> values) {
            addCriterion("proid in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<String> values) {
            addCriterion("proid not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(String value1, String value2) {
            addCriterion("proid between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(String value1, String value2) {
            addCriterion("proid not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeIsNull() {
            addCriterion("activityendtime is null");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeIsNotNull() {
            addCriterion("activityendtime is not null");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeEqualTo(Date value) {
            addCriterion("activityendtime =", value, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeNotEqualTo(Date value) {
            addCriterion("activityendtime <>", value, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeGreaterThan(Date value) {
            addCriterion("activityendtime >", value, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activityendtime >=", value, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeLessThan(Date value) {
            addCriterion("activityendtime <", value, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeLessThanOrEqualTo(Date value) {
            addCriterion("activityendtime <=", value, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeIn(List<Date> values) {
            addCriterion("activityendtime in", values, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeNotIn(List<Date> values) {
            addCriterion("activityendtime not in", values, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeBetween(Date value1, Date value2) {
            addCriterion("activityendtime between", value1, value2, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andActivityendtimeNotBetween(Date value1, Date value2) {
            addCriterion("activityendtime not between", value1, value2, "activityendtime");
            return (Criteria) this;
        }

        public Criteria andCoverpicIsNull() {
            addCriterion("coverpic is null");
            return (Criteria) this;
        }

        public Criteria andCoverpicIsNotNull() {
            addCriterion("coverpic is not null");
            return (Criteria) this;
        }

        public Criteria andCoverpicEqualTo(String value) {
            addCriterion("coverpic =", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicNotEqualTo(String value) {
            addCriterion("coverpic <>", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicGreaterThan(String value) {
            addCriterion("coverpic >", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicGreaterThanOrEqualTo(String value) {
            addCriterion("coverpic >=", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicLessThan(String value) {
            addCriterion("coverpic <", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicLessThanOrEqualTo(String value) {
            addCriterion("coverpic <=", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicLike(String value) {
            addCriterion("coverpic like", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicNotLike(String value) {
            addCriterion("coverpic not like", value, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicIn(List<String> values) {
            addCriterion("coverpic in", values, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicNotIn(List<String> values) {
            addCriterion("coverpic not in", values, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicBetween(String value1, String value2) {
            addCriterion("coverpic between", value1, value2, "coverpic");
            return (Criteria) this;
        }

        public Criteria andCoverpicNotBetween(String value1, String value2) {
            addCriterion("coverpic not between", value1, value2, "coverpic");
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