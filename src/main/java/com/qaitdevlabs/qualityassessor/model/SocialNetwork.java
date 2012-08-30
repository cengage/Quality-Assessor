package com.qaitdevlabs.qualityassessor.model;

/**
 * Created with IntelliJ IDEA.
 * User: anujchhabra
 * Date: 28/8/12
 * Time: 12:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class SocialNetwork {
    private Long socialNetworkId;
    private String socialSiteName;
    private String socialSiteId;
    private User user;

    public Long getSocialNetworkId() {
        return socialNetworkId;
    }

    public void setSocialNetworkId(Long socialNetworkId) {
        this.socialNetworkId = socialNetworkId;
    }

    public String getSocialSiteName() {
        return socialSiteName;
    }

    public void setSocialSiteName(String socialSiteName) {
        this.socialSiteName = socialSiteName;
    }

    public String getSocialSiteId() {
        return socialSiteId;
    }

    public void setSocialSiteId(String socialSiteId) {
        this.socialSiteId = socialSiteId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
