
package org.clb.mybatisTest.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 系统组织机构表
 *
 * @author ydx
 * @date 2022-07-11 14:36:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_org")
public class SysOrg extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父id
     */


    private Long pid;



    /**
     * 父ids
     */

    private String pids;



    /**
     * 组织层级，0-省、1-市、2-区（县）、3-街道（乡镇）、4-行政村、5-基层组织
     */

    private Integer layers;



    /**
     * 组织编码
     */

    private String code;



    /**
     * 组织名称
     */

    private String name;



    /**
     * 组织类型（001-农民专业合作社、002-家庭农场、003-涉农企业、004-政府机构）
     */

    private String orgType;



    /**
     * 统一社会信用代码
     */

    private String enterpriseCode;



    /**
     * 行业属性（001-种植业、002-畜牧业、003-渔业、004-农机服务）
     */

    private String industryAttribute;



    /**
     * 会计制度
     */

    private String accountSystem;



    /**
     * 负责人
     */

    private String linkMan;



    /**
     * 联系电话
     */

    private String mobilePhone;



    /**
     * 财务主管
     */

    private String treasurer;



    /**
     * 会计
     */

    private String accountPeople;



    /**
     * 出纳
     */

    private String cashier;



    /**
     * 开户银行
     */

    private String bankName;



    /**
     * 户名
     */

    private String accountName;



    /**
     * 银行账号
     */

    private String bankAccount;



    /**
     * 省
     */

    private String province;



    /**
     * 市
     */

    private String city;



    /**
     * 区县
     */

    private String county;



    /**
     * 街道
     */

    private String street;



    /**
     * 详细地址
     */

    private String address;



    /**
     * 组织状态（字典 0正常 1停用 2删除）
     */

    private Integer status;



    /**
     * 启用模块
     */

    private String enableModule;



    /**
     * 服务期限开始时间
     */

    private Date serviceStartTime;



    /**
     * 服务期限结束时间
     */

    private Date serviceEndTime;



    /**
     * 审核状态（0-待审核、1-通过、2-不通过）
     */

    private Integer verify;



    /**
     * 审核时间
     */

    private Date verifyTime;



    /**
     * 描述
     */

    private String description;



    /**
     * 用户数限定数
     */

    private Integer userCount;



    /**
     * 组织邀请码
     */

    private String invitationCode;



    /**
     * 组织性质（0-临时组织 1-正式组织  2-已经延期过得组织）
     */

    private Integer orgNature;



    /**
     * 是否是用户自行注册的组织（0-否， 1-是）
     */

    private Integer isRegister;

    /**
     * 组织末级字段
     */

    private Integer lastStage;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 序号
     */
    @TableField(exist = false)
    private Integer seq;

    /**
     * 所在地区
     */
    private String location;
    /**
     * 邮编
     */
    private String postalCode;
    /**
     *注册登记时间
     */
    private Date registerDate;
    /**
     *注册资金（万元）
     */
    private BigDecimal registerAmount;
    /**
     *营业执照
     */
    private String license;
    /**
     *会计
     */
    private String accounting;
    /**
     *是否成立理事会
     */
    private Integer isEstablishCouncil;
    /**
     *理事会成员
     */
    private String boardMember;
    /**
     *是否成立监事会
     */
    private Integer isEstablishBoard;
    /**
     *监事会成员
     */
    private String supervisorsMember;
    /**
     *理事长
     */
    private Long president;

    private Integer mainType;
    /**
     * 示范级别
     */
    private Integer demonstrationLevel;
    /**
     * 成员出资总额
     */
    private BigDecimal contribution;

    /**
     * 建立日期
     */
    private Date establishDate;

    /**
     * 业务范围
     */
    private String businessRange;

    /**
     * 启账日期
     */
    @TableField(exist = false)
    private Date initTime;



    /**
     * 补全组织编码
     * @param code
     * @param codeRulesLength
     * @return
     */
    public static String getCorrectCode(String code,int[] codeRulesLength){
        StringBuilder codeBuilder = new StringBuilder(code);
        for (int codeRule : codeRulesLength) {
            while(codeBuilder.length() < codeRule){ // 如果位数不够则补齐
                codeBuilder.append("0");
            }

            if(codeBuilder.length() == codeRule){
                break;
            }
        }
        code = codeBuilder.toString();

        return code;
    }

}
