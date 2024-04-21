package com.example.endpoints.entities.group;

import java.time.LocalDateTime;
import java.util.List;

import com.example.endpoints.entities.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="group-parent")
@Entity  
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @Exclude
    @JoinColumn(name="createdBy")
    
    private User createdBy;
    
    @ManyToOne
    @JoinColumn(name="updatedBy")
    @Exclude
    private User updatedBy;
    
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private int status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String profile;
    private String content;
    
    
    @OneToMany(mappedBy="groupId",cascade = CascadeType.ALL)
    private List<GroupMember>groupMembers;
    @OneToMany(mappedBy="groupId",cascade = CascadeType.ALL)
    private List<GroupFollower>groupFollwers;
    @OneToMany(mappedBy="groupId",cascade = CascadeType.ALL)
    private List<GroupMessage>messages;
    @OneToMany(mappedBy="groupId",cascade = CascadeType.ALL)
    private List<GroupPost>posts;
    @OneToMany(mappedBy="groupId",cascade = CascadeType.ALL)
    private List<GroupMeta>meta;
    
}
