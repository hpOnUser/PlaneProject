package hust.phone.mapper.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskidIsNull() {
            addCriterion("taskid is null");
            return (Criteria) this;
        }

        public Criteria andTaskidIsNotNull() {
            addCriterion("taskid is not null");
            return (Criteria) this;
        }

        public Criteria andTaskidEqualTo(String value) {
            addCriterion("taskid =", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotEqualTo(String value) {
            addCriterion("taskid <>", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThan(String value) {
            addCriterion("taskid >", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidGreaterThanOrEqualTo(String value) {
            addCriterion("taskid >=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThan(String value) {
            addCriterion("taskid <", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLessThanOrEqualTo(String value) {
            addCriterion("taskid <=", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidLike(String value) {
            addCriterion("taskid like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotLike(String value) {
            addCriterion("taskid not like", value, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidIn(List<String> values) {
            addCriterion("taskid in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotIn(List<String> values) {
            addCriterion("taskid not in", values, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidBetween(String value1, String value2) {
            addCriterion("taskid between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andTaskidNotBetween(String value1, String value2) {
            addCriterion("taskid not between", value1, value2, "taskid");
            return (Criteria) this;
        }

        public Criteria andUseraidIsNull() {
            addCriterion("userAid is null");
            return (Criteria) this;
        }

        public Criteria andUseraidIsNotNull() {
            addCriterion("userAid is not null");
            return (Criteria) this;
        }

        public Criteria andUseraidEqualTo(String value) {
            addCriterion("userAid =", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidNotEqualTo(String value) {
            addCriterion("userAid <>", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidGreaterThan(String value) {
            addCriterion("userAid >", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidGreaterThanOrEqualTo(String value) {
            addCriterion("userAid >=", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidLessThan(String value) {
            addCriterion("userAid <", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidLessThanOrEqualTo(String value) {
            addCriterion("userAid <=", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidLike(String value) {
            addCriterion("userAid like", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidNotLike(String value) {
            addCriterion("userAid not like", value, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidIn(List<String> values) {
            addCriterion("userAid in", values, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidNotIn(List<String> values) {
            addCriterion("userAid not in", values, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidBetween(String value1, String value2) {
            addCriterion("userAid between", value1, value2, "useraid");
            return (Criteria) this;
        }

        public Criteria andUseraidNotBetween(String value1, String value2) {
            addCriterion("userAid not between", value1, value2, "useraid");
            return (Criteria) this;
        }

        public Criteria andUserbidIsNull() {
            addCriterion("userBid is null");
            return (Criteria) this;
        }

        public Criteria andUserbidIsNotNull() {
            addCriterion("userBid is not null");
            return (Criteria) this;
        }

        public Criteria andUserbidEqualTo(String value) {
            addCriterion("userBid =", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidNotEqualTo(String value) {
            addCriterion("userBid <>", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidGreaterThan(String value) {
            addCriterion("userBid >", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidGreaterThanOrEqualTo(String value) {
            addCriterion("userBid >=", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidLessThan(String value) {
            addCriterion("userBid <", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidLessThanOrEqualTo(String value) {
            addCriterion("userBid <=", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidLike(String value) {
            addCriterion("userBid like", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidNotLike(String value) {
            addCriterion("userBid not like", value, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidIn(List<String> values) {
            addCriterion("userBid in", values, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidNotIn(List<String> values) {
            addCriterion("userBid not in", values, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidBetween(String value1, String value2) {
            addCriterion("userBid between", value1, value2, "userbid");
            return (Criteria) this;
        }

        public Criteria andUserbidNotBetween(String value1, String value2) {
            addCriterion("userBid not between", value1, value2, "userbid");
            return (Criteria) this;
        }

        public Criteria andUsercidIsNull() {
            addCriterion("userCid is null");
            return (Criteria) this;
        }

        public Criteria andUsercidIsNotNull() {
            addCriterion("userCid is not null");
            return (Criteria) this;
        }

        public Criteria andUsercidEqualTo(String value) {
            addCriterion("userCid =", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidNotEqualTo(String value) {
            addCriterion("userCid <>", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidGreaterThan(String value) {
            addCriterion("userCid >", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidGreaterThanOrEqualTo(String value) {
            addCriterion("userCid >=", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidLessThan(String value) {
            addCriterion("userCid <", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidLessThanOrEqualTo(String value) {
            addCriterion("userCid <=", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidLike(String value) {
            addCriterion("userCid like", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidNotLike(String value) {
            addCriterion("userCid not like", value, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidIn(List<String> values) {
            addCriterion("userCid in", values, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidNotIn(List<String> values) {
            addCriterion("userCid not in", values, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidBetween(String value1, String value2) {
            addCriterion("userCid between", value1, value2, "usercid");
            return (Criteria) this;
        }

        public Criteria andUsercidNotBetween(String value1, String value2) {
            addCriterion("userCid not between", value1, value2, "usercid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidIsNull() {
            addCriterion("planepathid is null");
            return (Criteria) this;
        }

        public Criteria andPlanepathidIsNotNull() {
            addCriterion("planepathid is not null");
            return (Criteria) this;
        }

        public Criteria andPlanepathidEqualTo(String value) {
            addCriterion("planepathid =", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidNotEqualTo(String value) {
            addCriterion("planepathid <>", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidGreaterThan(String value) {
            addCriterion("planepathid >", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidGreaterThanOrEqualTo(String value) {
            addCriterion("planepathid >=", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidLessThan(String value) {
            addCriterion("planepathid <", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidLessThanOrEqualTo(String value) {
            addCriterion("planepathid <=", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidLike(String value) {
            addCriterion("planepathid like", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidNotLike(String value) {
            addCriterion("planepathid not like", value, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidIn(List<String> values) {
            addCriterion("planepathid in", values, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidNotIn(List<String> values) {
            addCriterion("planepathid not in", values, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidBetween(String value1, String value2) {
            addCriterion("planepathid between", value1, value2, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlanepathidNotBetween(String value1, String value2) {
            addCriterion("planepathid not between", value1, value2, "planepathid");
            return (Criteria) this;
        }

        public Criteria andPlaneidIsNull() {
            addCriterion("planeid is null");
            return (Criteria) this;
        }

        public Criteria andPlaneidIsNotNull() {
            addCriterion("planeid is not null");
            return (Criteria) this;
        }

        public Criteria andPlaneidEqualTo(String value) {
            addCriterion("planeid =", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidNotEqualTo(String value) {
            addCriterion("planeid <>", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidGreaterThan(String value) {
            addCriterion("planeid >", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidGreaterThanOrEqualTo(String value) {
            addCriterion("planeid >=", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidLessThan(String value) {
            addCriterion("planeid <", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidLessThanOrEqualTo(String value) {
            addCriterion("planeid <=", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidLike(String value) {
            addCriterion("planeid like", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidNotLike(String value) {
            addCriterion("planeid not like", value, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidIn(List<String> values) {
            addCriterion("planeid in", values, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidNotIn(List<String> values) {
            addCriterion("planeid not in", values, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidBetween(String value1, String value2) {
            addCriterion("planeid between", value1, value2, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlaneidNotBetween(String value1, String value2) {
            addCriterion("planeid not between", value1, value2, "planeid");
            return (Criteria) this;
        }

        public Criteria andPlantimeIsNull() {
            addCriterion("plantime is null");
            return (Criteria) this;
        }

        public Criteria andPlantimeIsNotNull() {
            addCriterion("plantime is not null");
            return (Criteria) this;
        }

        public Criteria andPlantimeEqualTo(Date value) {
            addCriterion("plantime =", value, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeNotEqualTo(Date value) {
            addCriterion("plantime <>", value, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeGreaterThan(Date value) {
            addCriterion("plantime >", value, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeGreaterThanOrEqualTo(Date value) {
            addCriterion("plantime >=", value, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeLessThan(Date value) {
            addCriterion("plantime <", value, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeLessThanOrEqualTo(Date value) {
            addCriterion("plantime <=", value, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeIn(List<Date> values) {
            addCriterion("plantime in", values, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeNotIn(List<Date> values) {
            addCriterion("plantime not in", values, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeBetween(Date value1, Date value2) {
            addCriterion("plantime between", value1, value2, "plantime");
            return (Criteria) this;
        }

        public Criteria andPlantimeNotBetween(Date value1, Date value2) {
            addCriterion("plantime not between", value1, value2, "plantime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeIsNull() {
            addCriterion("realtime is null");
            return (Criteria) this;
        }

        public Criteria andRealtimeIsNotNull() {
            addCriterion("realtime is not null");
            return (Criteria) this;
        }

        public Criteria andRealtimeEqualTo(Date value) {
            addCriterion("realtime =", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotEqualTo(Date value) {
            addCriterion("realtime <>", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeGreaterThan(Date value) {
            addCriterion("realtime >", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("realtime >=", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLessThan(Date value) {
            addCriterion("realtime <", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeLessThanOrEqualTo(Date value) {
            addCriterion("realtime <=", value, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeIn(List<Date> values) {
            addCriterion("realtime in", values, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotIn(List<Date> values) {
            addCriterion("realtime not in", values, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeBetween(Date value1, Date value2) {
            addCriterion("realtime between", value1, value2, "realtime");
            return (Criteria) this;
        }

        public Criteria andRealtimeNotBetween(Date value1, Date value2) {
            addCriterion("realtime not between", value1, value2, "realtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andFinishstatusIsNull() {
            addCriterion("finishstatus is null");
            return (Criteria) this;
        }

        public Criteria andFinishstatusIsNotNull() {
            addCriterion("finishstatus is not null");
            return (Criteria) this;
        }

        public Criteria andFinishstatusEqualTo(String value) {
            addCriterion("finishstatus =", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusNotEqualTo(String value) {
            addCriterion("finishstatus <>", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusGreaterThan(String value) {
            addCriterion("finishstatus >", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusGreaterThanOrEqualTo(String value) {
            addCriterion("finishstatus >=", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusLessThan(String value) {
            addCriterion("finishstatus <", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusLessThanOrEqualTo(String value) {
            addCriterion("finishstatus <=", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusLike(String value) {
            addCriterion("finishstatus like", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusNotLike(String value) {
            addCriterion("finishstatus not like", value, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusIn(List<String> values) {
            addCriterion("finishstatus in", values, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusNotIn(List<String> values) {
            addCriterion("finishstatus not in", values, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusBetween(String value1, String value2) {
            addCriterion("finishstatus between", value1, value2, "finishstatus");
            return (Criteria) this;
        }

        public Criteria andFinishstatusNotBetween(String value1, String value2) {
            addCriterion("finishstatus not between", value1, value2, "finishstatus");
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