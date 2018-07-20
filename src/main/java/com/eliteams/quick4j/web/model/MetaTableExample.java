package com.eliteams.quick4j.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MetaTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MetaTableExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTimingIsNull() {
            addCriterion("timing is null");
            return (Criteria) this;
        }

        public Criteria andTimingIsNotNull() {
            addCriterion("timing is not null");
            return (Criteria) this;
        }

        public Criteria andTimingEqualTo(String value) {
            addCriterion("timing =", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingNotEqualTo(String value) {
            addCriterion("timing <>", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingGreaterThan(String value) {
            addCriterion("timing >", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingGreaterThanOrEqualTo(String value) {
            addCriterion("timing >=", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingLessThan(String value) {
            addCriterion("timing <", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingLessThanOrEqualTo(String value) {
            addCriterion("timing <=", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingLike(String value) {
            addCriterion("timing like", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingNotLike(String value) {
            addCriterion("timing not like", value, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingIn(List<String> values) {
            addCriterion("timing in", values, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingNotIn(List<String> values) {
            addCriterion("timing not in", values, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingBetween(String value1, String value2) {
            addCriterion("timing between", value1, value2, "timing");
            return (Criteria) this;
        }

        public Criteria andTimingNotBetween(String value1, String value2) {
            addCriterion("timing not between", value1, value2, "timing");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNull() {
            addCriterion("riqi is null");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNotNull() {
            addCriterion("riqi is not null");
            return (Criteria) this;
        }

        public Criteria andRiqiEqualTo(Date value) {
            addCriterionForJDBCDate("riqi =", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotEqualTo(Date value) {
            addCriterionForJDBCDate("riqi <>", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThan(Date value) {
            addCriterionForJDBCDate("riqi >", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("riqi >=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThan(Date value) {
            addCriterionForJDBCDate("riqi <", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("riqi <=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiIn(List<Date> values) {
            addCriterionForJDBCDate("riqi in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotIn(List<Date> values) {
            addCriterionForJDBCDate("riqi not in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("riqi between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("riqi not between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andZuozheIsNull() {
            addCriterion("zuozhe is null");
            return (Criteria) this;
        }

        public Criteria andZuozheIsNotNull() {
            addCriterion("zuozhe is not null");
            return (Criteria) this;
        }

        public Criteria andZuozheEqualTo(String value) {
            addCriterion("zuozhe =", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheNotEqualTo(String value) {
            addCriterion("zuozhe <>", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheGreaterThan(String value) {
            addCriterion("zuozhe >", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheGreaterThanOrEqualTo(String value) {
            addCriterion("zuozhe >=", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheLessThan(String value) {
            addCriterion("zuozhe <", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheLessThanOrEqualTo(String value) {
            addCriterion("zuozhe <=", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheLike(String value) {
            addCriterion("zuozhe like", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheNotLike(String value) {
            addCriterion("zuozhe not like", value, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheIn(List<String> values) {
            addCriterion("zuozhe in", values, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheNotIn(List<String> values) {
            addCriterion("zuozhe not in", values, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheBetween(String value1, String value2) {
            addCriterion("zuozhe between", value1, value2, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZuozheNotBetween(String value1, String value2) {
            addCriterion("zuozhe not between", value1, value2, "zuozhe");
            return (Criteria) this;
        }

        public Criteria andZhutiIsNull() {
            addCriterion("zhuti is null");
            return (Criteria) this;
        }

        public Criteria andZhutiIsNotNull() {
            addCriterion("zhuti is not null");
            return (Criteria) this;
        }

        public Criteria andZhutiEqualTo(String value) {
            addCriterion("zhuti =", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiNotEqualTo(String value) {
            addCriterion("zhuti <>", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiGreaterThan(String value) {
            addCriterion("zhuti >", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiGreaterThanOrEqualTo(String value) {
            addCriterion("zhuti >=", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiLessThan(String value) {
            addCriterion("zhuti <", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiLessThanOrEqualTo(String value) {
            addCriterion("zhuti <=", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiLike(String value) {
            addCriterion("zhuti like", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiNotLike(String value) {
            addCriterion("zhuti not like", value, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiIn(List<String> values) {
            addCriterion("zhuti in", values, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiNotIn(List<String> values) {
            addCriterion("zhuti not in", values, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiBetween(String value1, String value2) {
            addCriterion("zhuti between", value1, value2, "zhuti");
            return (Criteria) this;
        }

        public Criteria andZhutiNotBetween(String value1, String value2) {
            addCriterion("zhuti not between", value1, value2, "zhuti");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNull() {
            addCriterion("leixing is null");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNotNull() {
            addCriterion("leixing is not null");
            return (Criteria) this;
        }

        public Criteria andLeixingEqualTo(String value) {
            addCriterion("leixing =", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotEqualTo(String value) {
            addCriterion("leixing <>", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThan(String value) {
            addCriterion("leixing >", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThanOrEqualTo(String value) {
            addCriterion("leixing >=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThan(String value) {
            addCriterion("leixing <", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThanOrEqualTo(String value) {
            addCriterion("leixing <=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLike(String value) {
            addCriterion("leixing like", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotLike(String value) {
            addCriterion("leixing not like", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingIn(List<String> values) {
            addCriterion("leixing in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotIn(List<String> values) {
            addCriterion("leixing not in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingBetween(String value1, String value2) {
            addCriterion("leixing between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotBetween(String value1, String value2) {
            addCriterion("leixing not between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andDaxiaoIsNull() {
            addCriterion("daxiao is null");
            return (Criteria) this;
        }

        public Criteria andDaxiaoIsNotNull() {
            addCriterion("daxiao is not null");
            return (Criteria) this;
        }

        public Criteria andDaxiaoEqualTo(String value) {
            addCriterion("daxiao =", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoNotEqualTo(String value) {
            addCriterion("daxiao <>", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoGreaterThan(String value) {
            addCriterion("daxiao >", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoGreaterThanOrEqualTo(String value) {
            addCriterion("daxiao >=", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoLessThan(String value) {
            addCriterion("daxiao <", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoLessThanOrEqualTo(String value) {
            addCriterion("daxiao <=", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoLike(String value) {
            addCriterion("daxiao like", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoNotLike(String value) {
            addCriterion("daxiao not like", value, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoIn(List<String> values) {
            addCriterion("daxiao in", values, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoNotIn(List<String> values) {
            addCriterion("daxiao not in", values, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoBetween(String value1, String value2) {
            addCriterion("daxiao between", value1, value2, "daxiao");
            return (Criteria) this;
        }

        public Criteria andDaxiaoNotBetween(String value1, String value2) {
            addCriterion("daxiao not between", value1, value2, "daxiao");
            return (Criteria) this;
        }

        public Criteria andGeshiIsNull() {
            addCriterion("geshi is null");
            return (Criteria) this;
        }

        public Criteria andGeshiIsNotNull() {
            addCriterion("geshi is not null");
            return (Criteria) this;
        }

        public Criteria andGeshiEqualTo(String value) {
            addCriterion("geshi =", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiNotEqualTo(String value) {
            addCriterion("geshi <>", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiGreaterThan(String value) {
            addCriterion("geshi >", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiGreaterThanOrEqualTo(String value) {
            addCriterion("geshi >=", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiLessThan(String value) {
            addCriterion("geshi <", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiLessThanOrEqualTo(String value) {
            addCriterion("geshi <=", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiLike(String value) {
            addCriterion("geshi like", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiNotLike(String value) {
            addCriterion("geshi not like", value, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiIn(List<String> values) {
            addCriterion("geshi in", values, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiNotIn(List<String> values) {
            addCriterion("geshi not in", values, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiBetween(String value1, String value2) {
            addCriterion("geshi between", value1, value2, "geshi");
            return (Criteria) this;
        }

        public Criteria andGeshiNotBetween(String value1, String value2) {
            addCriterion("geshi not between", value1, value2, "geshi");
            return (Criteria) this;
        }

        public Criteria andLaiyuanIsNull() {
            addCriterion("laiyuan is null");
            return (Criteria) this;
        }

        public Criteria andLaiyuanIsNotNull() {
            addCriterion("laiyuan is not null");
            return (Criteria) this;
        }

        public Criteria andLaiyuanEqualTo(String value) {
            addCriterion("laiyuan =", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanNotEqualTo(String value) {
            addCriterion("laiyuan <>", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanGreaterThan(String value) {
            addCriterion("laiyuan >", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanGreaterThanOrEqualTo(String value) {
            addCriterion("laiyuan >=", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanLessThan(String value) {
            addCriterion("laiyuan <", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanLessThanOrEqualTo(String value) {
            addCriterion("laiyuan <=", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanLike(String value) {
            addCriterion("laiyuan like", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanNotLike(String value) {
            addCriterion("laiyuan not like", value, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanIn(List<String> values) {
            addCriterion("laiyuan in", values, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanNotIn(List<String> values) {
            addCriterion("laiyuan not in", values, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanBetween(String value1, String value2) {
            addCriterion("laiyuan between", value1, value2, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andLaiyuanNotBetween(String value1, String value2) {
            addCriterion("laiyuan not between", value1, value2, "laiyuan");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andCunchuIsNull() {
            addCriterion("cunchu is null");
            return (Criteria) this;
        }

        public Criteria andCunchuIsNotNull() {
            addCriterion("cunchu is not null");
            return (Criteria) this;
        }

        public Criteria andCunchuEqualTo(String value) {
            addCriterion("cunchu =", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuNotEqualTo(String value) {
            addCriterion("cunchu <>", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuGreaterThan(String value) {
            addCriterion("cunchu >", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuGreaterThanOrEqualTo(String value) {
            addCriterion("cunchu >=", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuLessThan(String value) {
            addCriterion("cunchu <", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuLessThanOrEqualTo(String value) {
            addCriterion("cunchu <=", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuLike(String value) {
            addCriterion("cunchu like", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuNotLike(String value) {
            addCriterion("cunchu not like", value, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuIn(List<String> values) {
            addCriterion("cunchu in", values, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuNotIn(List<String> values) {
            addCriterion("cunchu not in", values, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuBetween(String value1, String value2) {
            addCriterion("cunchu between", value1, value2, "cunchu");
            return (Criteria) this;
        }

        public Criteria andCunchuNotBetween(String value1, String value2) {
            addCriterion("cunchu not between", value1, value2, "cunchu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNull() {
            addCriterion("beizhu is null");
            return (Criteria) this;
        }

        public Criteria andBeizhuIsNotNull() {
            addCriterion("beizhu is not null");
            return (Criteria) this;
        }

        public Criteria andBeizhuEqualTo(String value) {
            addCriterion("beizhu =", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotEqualTo(String value) {
            addCriterion("beizhu <>", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThan(String value) {
            addCriterion("beizhu >", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuGreaterThanOrEqualTo(String value) {
            addCriterion("beizhu >=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThan(String value) {
            addCriterion("beizhu <", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLessThanOrEqualTo(String value) {
            addCriterion("beizhu <=", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuLike(String value) {
            addCriterion("beizhu like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotLike(String value) {
            addCriterion("beizhu not like", value, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuIn(List<String> values) {
            addCriterion("beizhu in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotIn(List<String> values) {
            addCriterion("beizhu not in", values, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuBetween(String value1, String value2) {
            addCriterion("beizhu between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andBeizhuNotBetween(String value1, String value2) {
            addCriterion("beizhu not between", value1, value2, "beizhu");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
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