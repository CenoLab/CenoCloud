package com.iot.nero.parent_facade.entity;


import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/18
 * Time   上午9:58
 */
public class Article implements Serializable {

    private Integer    id;
    private Integer    authorId;
    private String  title;
    private String  content;
    private Long    readCount;
    private String  tagsId;
    private Integer  canComment;
    private String  abstractContent;
    private Integer  type;
    private Long    startCount;
    private String  fromWhere;
    private String  fromUrl;
    private Integer starCount;
    private Integer favCount;
    private Long    del;
    private String  modifyTime;
    private String  createTime;


    public Article() {
    }

    public Article(Integer id, Integer authorId, String title, String content, Long readCount, String tagsId, Integer canComment, String abstractContent, Integer type, Long startCount, String fromWhere, String fromUrl, Integer starCount, Integer favCount, Long del, String modifyTime, String createTime) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.readCount = readCount;
        this.tagsId = tagsId;
        this.canComment = canComment;
        this.abstractContent = abstractContent;
        this.type = type;
        this.startCount = startCount;
        this.fromWhere = fromWhere;
        this.fromUrl = fromUrl;
        this.starCount = starCount;
        this.favCount = favCount;
        this.del = del;
        this.modifyTime = modifyTime;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public String getTagsId() {
        return tagsId;
    }

    public void setTagsId(String tagsId) {
        this.tagsId = tagsId;
    }

    public Integer getCanComment() {
        return canComment;
    }

    public void setCanComment(Integer canComment) {
        this.canComment = canComment;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getStartCount() {
        return startCount;
    }

    public void setStartCount(Long startCount) {
        this.startCount = startCount;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public void setFromWhere(String fromWhere) {
        this.fromWhere = fromWhere;
    }

    public String getFromUrl() {
        return fromUrl;
    }
    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public Long getDel() {
        return del;
    }

    public void setDel(Long del) {
        this.del = del;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", readCount=" + readCount +
                ", tagsId='" + tagsId + '\'' +
                ", canComment=" + canComment +
                ", abstractContent='" + abstractContent + '\'' +
                ", type=" + type +
                ", startCount=" + startCount +
                ", fromWhere='" + fromWhere + '\'' +
                ", fromWrl='" + fromUrl + '\'' +
                ", starCount=" + starCount +
                ", favCount=" + favCount +
                ", del=" + del +
                ", modifyTime='" + modifyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public Integer getStarCount() {
        return starCount;
    }

    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }


    public Article toArticleBase(){
        String regExImg = "(?is)<img\\s*((?<key>[^=]+)=\"*(?<value>[^\"]+)\")+?\\s*/?>";
        Pattern pImage = Pattern.compile(regExImg, Pattern.CASE_INSENSITIVE);
        Matcher mImage = pImage.matcher(content);


        while (mImage.find()) {
            // 得到<img />数据
            String img = mImage.group();
            System.out.println(img);
            this.content = img;

            // 匹配<img>中的src数据
            Matcher mSrc = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while(mSrc.find()) {
                this.content = mSrc.group().split("\"")[1];
            }
            return this;
        }
        content=null;
        return this;
    }

//    public static void main(String[] args){
//        String content = "<sr></src><src></src></><a>asdasdas</a><img src=\"www.cenocloud.com/logo.png\"/><h1>asdasdasdasdasd</h1>";
//        String regExImg = "(?is)<img\\s*((?<key>[^=]+)=\"*(?<value>[^\"]+)\")+?\\s*/?>";
//        Pattern pImage = Pattern.compile(regExImg, Pattern.CASE_INSENSITIVE);
//        Matcher mImage = pImage.matcher(content);
//
//
//        while (mImage.find()) {
//            // 得到<img />数据
//            String img = mImage.group();
//            System.out.println(img);
//
//            // 匹配<img>中的src数据
//            Matcher mSrc = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
//            while(mSrc.find()) {
//                System.out.println(mSrc.group().split("\"")[1]);
//            }
//        }
//    }
}