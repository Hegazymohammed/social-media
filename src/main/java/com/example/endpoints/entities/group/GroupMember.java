package com.example.endpoints.entities.group;

import java.time.LocalDateTime;

import com.example.endpoints.entities.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Entity
@Table(name="group_member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int type;
    private int status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;
    @ManyToOne
    @JoinColumn(name="groupId")
    @Exclude
    private Group groupId;
    
    @ManyToOne
    @JoinColumn(name="userId")
    @Exclude
    private User userId;
}
