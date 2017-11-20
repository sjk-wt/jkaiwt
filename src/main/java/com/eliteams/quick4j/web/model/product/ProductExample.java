package com.eliteams.quick4j.web.model.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andPcolorIsNull() {
            addCriterion("pcolor is null");
            return (Criteria) this;
        }

        public Criteria andPcolorIsNotNull() {
            addCriterion("pcolor is not null");
            return (Criteria) this;
        }

        public Criteria andPcolorEqualTo(String value) {
            addCriterion("pcolor =", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorNotEqualTo(String value) {
            addCriterion("pcolor <>", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorGreaterThan(String value) {
            addCriterion("pcolor >", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorGreaterThanOrEqualTo(String value) {
            addCriterion("pcolor >=", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorLessThan(String value) {
            addCriterion("pcolor <", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorLessThanOrEqualTo(String value) {
            addCriterion("pcolor <=", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorLike(String value) {
            addCriterion("pcolor like", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorNotLike(String value) {
            addCriterion("pcolor not like", value, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorIn(List<String> values) {
            addCriterion("pcolor in", values, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorNotIn(List<String> values) {
            addCriterion("pcolor not in", values, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorBetween(String value1, String value2) {
            addCriterion("pcolor between", value1, value2, "pcolor");
            return (Criteria) this;
        }

        public Criteria andPcolorNotBetween(String value1, String value2) {
            addCriterion("pcolor not between", value1, value2, "pcolor");
            return (Criteria) this;
        }

        public Criteria andEffectpicIsNull() {
            addCriterion("effectpic is null");
            return (Criteria) this;
        }

        public Criteria andEffectpicIsNotNull() {
            addCriterion("effectpic is not null");
            return (Criteria) this;
        }

        public Criteria andEffectpicEqualTo(String value) {
            addCriterion("effectpic =", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicNotEqualTo(String value) {
            addCriterion("effectpic <>", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicGreaterThan(String value) {
            addCriterion("effectpic >", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicGreaterThanOrEqualTo(String value) {
            addCriterion("effectpic >=", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicLessThan(String value) {
            addCriterion("effectpic <", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicLessThanOrEqualTo(String value) {
            addCriterion("effectpic <=", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicLike(String value) {
            addCriterion("effectpic like", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicNotLike(String value) {
            addCriterion("effectpic not like", value, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicIn(List<String> values) {
            addCriterion("effectpic in", values, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicNotIn(List<String> values) {
            addCriterion("effectpic not in", values, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicBetween(String value1, String value2) {
            addCriterion("effectpic between", value1, value2, "effectpic");
            return (Criteria) this;
        }

        public Criteria andEffectpicNotBetween(String value1, String value2) {
            addCriterion("effectpic not between", value1, value2, "effectpic");
            return (Criteria) this;
        }

        public Criteria andUsepicIsNull() {
            addCriterion("usepic is null");
            return (Criteria) this;
        }

        public Criteria andUsepicIsNotNull() {
            addCriterion("usepic is not null");
            return (Criteria) this;
        }

        public Criteria andUsepicEqualTo(String value) {
            addCriterion("usepic =", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicNotEqualTo(String value) {
            addCriterion("usepic <>", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicGreaterThan(String value) {
            addCriterion("usepic >", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicGreaterThanOrEqualTo(String value) {
            addCriterion("usepic >=", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicLessThan(String value) {
            addCriterion("usepic <", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicLessThanOrEqualTo(String value) {
            addCriterion("usepic <=", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicLike(String value) {
            addCriterion("usepic like", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicNotLike(String value) {
            addCriterion("usepic not like", value, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicIn(List<String> values) {
            addCriterion("usepic in", values, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicNotIn(List<String> values) {
            addCriterion("usepic not in", values, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicBetween(String value1, String value2) {
            addCriterion("usepic between", value1, value2, "usepic");
            return (Criteria) this;
        }

        public Criteria andUsepicNotBetween(String value1, String value2) {
            addCriterion("usepic not between", value1, value2, "usepic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicIsNull() {
            addCriterion("capacitypic is null");
            return (Criteria) this;
        }

        public Criteria andCapacitypicIsNotNull() {
            addCriterion("capacitypic is not null");
            return (Criteria) this;
        }

        public Criteria andCapacitypicEqualTo(String value) {
            addCriterion("capacitypic =", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicNotEqualTo(String value) {
            addCriterion("capacitypic <>", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicGreaterThan(String value) {
            addCriterion("capacitypic >", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicGreaterThanOrEqualTo(String value) {
            addCriterion("capacitypic >=", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicLessThan(String value) {
            addCriterion("capacitypic <", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicLessThanOrEqualTo(String value) {
            addCriterion("capacitypic <=", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicLike(String value) {
            addCriterion("capacitypic like", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicNotLike(String value) {
            addCriterion("capacitypic not like", value, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicIn(List<String> values) {
            addCriterion("capacitypic in", values, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicNotIn(List<String> values) {
            addCriterion("capacitypic not in", values, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicBetween(String value1, String value2) {
            addCriterion("capacitypic between", value1, value2, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andCapacitypicNotBetween(String value1, String value2) {
            addCriterion("capacitypic not between", value1, value2, "capacitypic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicIsNull() {
            addCriterion("ensurepic is null");
            return (Criteria) this;
        }

        public Criteria andEnsurepicIsNotNull() {
            addCriterion("ensurepic is not null");
            return (Criteria) this;
        }

        public Criteria andEnsurepicEqualTo(String value) {
            addCriterion("ensurepic =", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicNotEqualTo(String value) {
            addCriterion("ensurepic <>", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicGreaterThan(String value) {
            addCriterion("ensurepic >", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicGreaterThanOrEqualTo(String value) {
            addCriterion("ensurepic >=", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicLessThan(String value) {
            addCriterion("ensurepic <", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicLessThanOrEqualTo(String value) {
            addCriterion("ensurepic <=", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicLike(String value) {
            addCriterion("ensurepic like", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicNotLike(String value) {
            addCriterion("ensurepic not like", value, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicIn(List<String> values) {
            addCriterion("ensurepic in", values, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicNotIn(List<String> values) {
            addCriterion("ensurepic not in", values, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicBetween(String value1, String value2) {
            addCriterion("ensurepic between", value1, value2, "ensurepic");
            return (Criteria) this;
        }

        public Criteria andEnsurepicNotBetween(String value1, String value2) {
            addCriterion("ensurepic not between", value1, value2, "ensurepic");
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

        public Criteria andInstarttimeIsNull() {
            addCriterion("instarttime is null");
            return (Criteria) this;
        }

        public Criteria andInstarttimeIsNotNull() {
            addCriterion("instarttime is not null");
            return (Criteria) this;
        }

        public Criteria andInstarttimeEqualTo(Date value) {
            addCriterion("instarttime =", value, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeNotEqualTo(Date value) {
            addCriterion("instarttime <>", value, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeGreaterThan(Date value) {
            addCriterion("instarttime >", value, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("instarttime >=", value, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeLessThan(Date value) {
            addCriterion("instarttime <", value, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeLessThanOrEqualTo(Date value) {
            addCriterion("instarttime <=", value, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeIn(List<Date> values) {
            addCriterion("instarttime in", values, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeNotIn(List<Date> values) {
            addCriterion("instarttime not in", values, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeBetween(Date value1, Date value2) {
            addCriterion("instarttime between", value1, value2, "instarttime");
            return (Criteria) this;
        }

        public Criteria andInstarttimeNotBetween(Date value1, Date value2) {
            addCriterion("instarttime not between", value1, value2, "instarttime");
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