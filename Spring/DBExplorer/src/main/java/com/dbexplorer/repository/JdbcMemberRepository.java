package com.dbexplorer.repository;

import com.dbexplorer.domain.Member;
import com.dbexplorer.domain.Member.MemberBuilder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class JdbcMemberRepository implements MemberRepository {
    @Override
    public Member save(Member member) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("INSERT INTO MEMBER (LOGIN_ID, PASSWORD, NAME) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getLoginId());
            ps.setString(2, member.getPassword());
            ps.setString(3, member.getName());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                Long id = rs.getLong(1);
                member.setId(id);
            }
            return member;
        } catch (SQLException e) {
            log.error("ERROR 발생", e);
        }
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("SELECT * FROM MEMBER WHERE ID = ?");
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                Member member = Member.builder()
                        .id(rs.getLong(1))
                        .loginId(rs.getString(2))
                        .password(rs.getString(3))
                        .name(rs.getString(4))
                        .build();
                return Optional.of(member);
            }
            return Optional.empty();
        } catch (SQLException e) {
            log.error("ERROR", e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("SELECT * FROM MEMBER WHERE LOGIN_ID = ?");
            ps.setString(1, loginId);
            rs = ps.executeQuery();

            if (rs.next()) {
                Member member = Member.builder()
                        .id(rs.getLong(1))
                        .loginId(rs.getString(2))
                        .password(rs.getString(3))
                        .name(rs.getString(4))
                        .build();
                return Optional.of(member);
            }
        } catch (SQLException e) {
            log.error("ERROR", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();
            ps = con.prepareStatement("SELECT * FROM MEMBER");
            rs = ps.executeQuery();

            List<Member> members = new ArrayList<>();
            while (rs.next()) {
                Member member = Member.builder()
                        .id(rs.getLong(1))
                        .loginId(rs.getString(2))
                        .password(rs.getString(3))
                        .name(rs.getString(4))
                        .build();
                members.add(member);
            }
            return members;
        } catch (SQLException e) {
            log.error("ERROR", e);
        }
        return List.of();
    }

    @Override
    public Member update(Long id, Member member) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("UPDATE MEMBER SET PASSWORD = ?, NAME = ? WHERE ID = ?");
            ps.setString(1, member.getPassword());
            ps.setString(2, member.getName());
            ps.setLong(3, id);
            ps.executeUpdate();
            return findById(id).get();
        } catch (SQLException e) {
            log.error("ERROR", e);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement("DELETE MEMBER WHERE ID = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            log.error("ERROR", e);
        }
        return false;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }
}
