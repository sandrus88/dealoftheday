package org.dealoftheday.admin.menu;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Cloneable, Serializable {

    private static final long serialVersionUID = -1L;

    private String id;
    private String label;
    private String link;

    private List<MenuItem> children = new ArrayList<MenuItem>();
    private String roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<MenuItem> getChildren() {
        return children;
    }

    public void setChildren(List<MenuItem> children) {
        this.children = children;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean equals(final Object other) {
        if (!(other instanceof MenuItem))
            return false;
        MenuItem castOther = (MenuItem) other;
        return new EqualsBuilder().append(id, castOther.id).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString())
                .append("id", id)
                .append("label", label)
                .append("link", link)
                .append("children", children)
                .append("roles", roles).toString();
    }

    @Override
    public Object clone() {
        MenuItem clone = new MenuItem();
        clone.id = this.id;
        clone.label = this.label;
        clone.link = this.link;
        clone.children = this.children;
        clone.roles = this.roles;
        return clone;
    }
}