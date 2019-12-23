package com.test;

public class CONST_HTML_CODE
{
    //milestone
    public static final String PLACEHOLDER_MILESTONE_DATE_CODE = "##DATE##";
    public static final String PLACEHOLDER_MILESTONE_COMMENT_CODE = "##COMMENT##";
    public static final String PLACEHOLDER_MILESTONE_STATUS_CODE = "##STATUS##";
    public static final String PLACEHOLDER_MILESTONE_CLASS = "##MILESTEONE_CLASS##";
    public static final String MILESTONE_CLASS = "milestone";
    public static final String MILESTONE_END_CLASS = "milestoneEnd";
    public static final String PLACEHOLDER_MILESTONE_STATUS_DONE_CODE = "<label class=\"container\"><input type=\"checkbox\" checked><span class=\"checkmark\" ></span></label>";
    public static final String PLACEHOLDER_MILESTONE_STATUS_IN_PROGRESS_CODE = "<label class=\"container\"><input type=\"checkbox\" ><span class=\"checkmark\"></span></label>";
    public static final String PLACEHOLDER_MILESTONE_STATUS_REDY_CODE = "<label class=\"container\"><input type=\"checkbox\" ><span class=\"checkmark\"></span></label>";
    public static final String PLACEHOLDER_MILESTONE_STATUS_DELIVERY_CODE = "<label class=\"container\"><input type=\"checkbox\" ><span class=\"checkmark\"></span></label>";
//    public static final String PLACEHOLDER_MILESTONE_STATUS_DONE_CODE = "<i class=\"far fa-check-circle\"> </i>";
//    public static final String PLACEHOLDER_MILESTONE_STATUS_IN_PROGRESS_CODE = "<i class=\"fas fa-sync-alt\"></i>";
//    public static final String PLACEHOLDER_MILESTONE_STATUS_REDY_CODE = "<i class=\"fas fa-sync-alt\"></i>";
//    public static final String PLACEHOLDER_MILESTONE_STATUS_DELIVERY_CODE = "<i class=\"fas fa-sync-alt\"></i>";
    public static final String CSS_MILESTONE_CLASS= "\""+PLACEHOLDER_MILESTONE_CLASS+"\"";
    public static final String CSS_MILESTONE_DATE_DIV_CLASS="\"milestoneDateDiv\"";
    public static final String HTML_MILESTONE_DATE_DIV = "<div class=" + CSS_MILESTONE_DATE_DIV_CLASS+">"+ PLACEHOLDER_MILESTONE_DATE_CODE +"</div>";
    public static final String CSS_MILESTONE_COMMENT_DIV_CLASS="\"milestoneComment\"";
    public static final String HTML_MILESTONE_COMMENT_DIV = "<div class=" + CSS_MILESTONE_COMMENT_DIV_CLASS+">"+ PLACEHOLDER_MILESTONE_COMMENT_CODE +"</div>";
    public static final String CSS_MILESTONE_STATUS_DIV_CLASS="\"milestonestatus\"";
    public static final String HTML_MILESTONE_STATUS_DIV = "<div class=" + CSS_MILESTONE_STATUS_DIV_CLASS+">"+ PLACEHOLDER_MILESTONE_STATUS_CODE +"</div>";
    public static final String HTML_MILESTONE_DIV =  "<div class="+CSS_MILESTONE_CLASS+">" + HTML_MILESTONE_DATE_DIV
            + HTML_MILESTONE_COMMENT_DIV + HTML_MILESTONE_STATUS_DIV + "</div>";

    public static final String CSS_PRODUCT_CLASS = "\"product\"";
    public static final String CSS_PRODUCT_NAME_CLASS = "\"productName\"";
    public static final String CSS_PRODUCT_COMMENT_CLASS = "\"productComment\"";

    public static final String PLACEHOLDER_PRODUCT_NAME = "##PRODUCT_NAME##";
    public static final String HTML_PRODUCT_DIV_START_CODE = "<div class=" + CSS_PRODUCT_CLASS + ">";
    public static final String HTML_PRODUCT_DIV_END_CODE = "</div>";
    public static final String HTML_PRODUCT_NAME_DIV_CODE = "<div class=" + CSS_PRODUCT_NAME_CLASS + ">"+PLACEHOLDER_PRODUCT_NAME + "</div>";
    public static final String HTML_PRODUCT_COMMENT_DIV_CODE = "<div class=" + CSS_PRODUCT_COMMENT_CLASS + ">"+"שם תוצר"+"</div>";
    public static final String HTML_PRODUCT_CODE = HTML_PRODUCT_DIV_START_CODE + HTML_PRODUCT_NAME_DIV_CODE +
            HTML_PRODUCT_COMMENT_DIV_CODE + HTML_PRODUCT_DIV_END_CODE;

    public static final String HTML_PRODUCT_WRAPPER_START = "<div class=\"productsDataID\">";
    public static final String HTML_PRODUCT_WRAPPER_END = "</div>";
    public static final String PLACEHOLDER_BTN_ID = "##BTN_ID##";
    public static final String HTML_PRODUCT_BTN="<button class=\"productBtn\" onclick=\"setProductBtn(this.id)\" id=\""+PLACEHOLDER_BTN_ID+"\"><a  href=\"#setProductPopUpID\"><i class=\"far\" id=\"editproductBtnID\">&#xf044;</i></a></button>";
    public static final String HTML_PRODUCT_UP_WRAPPER_START = "<div class=\"productsID\">";
    public static final String HTML_PRODUCT_UP_WRAPPER_END= "</div>";

}

