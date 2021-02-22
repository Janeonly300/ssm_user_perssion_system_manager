package com.atjianyi.pojo;

/**
 * @author 简一
 * @className Member
 * @Date 2021/2/22 15:42
 **/
public class Member {
    private String id;
    private String memberName;
    private String memberNickName;
    private String memberPhone;
    private String memberEmail;

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberNickName='" + memberNickName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
}
