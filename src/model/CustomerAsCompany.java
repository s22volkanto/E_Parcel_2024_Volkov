package model;

public class CustomerAsCompany extends AbstractCustomer{
    private String title;
    private String companyRegNo;

    public CustomerAsCompany() {}

    public CustomerAsCompany(Address address, String phone, String title, String companyRegNo) {
        super(address, phone);
        this.title = title;
        this.companyRegNo = companyRegNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyRegNo() {
        return companyRegNo;
    }

    public void setCompanyRegNo(String companyRegNo) {
        this.companyRegNo = companyRegNo;
    }

    @Override
    public String toString() {
        return "CustomerAsCompany{" +
                "title='" + title + '\'' +
                ", companyRegNo='" + companyRegNo + '\'' +
                '}';
    }
}
