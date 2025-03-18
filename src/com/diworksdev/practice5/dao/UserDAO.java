package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.practice5.dto.UserDTO;
import com.diworksdev.practice5.util.DBConnector;

public class UserDAO {

	private DBConnector dbConnector = new DBConnector();

    public boolean updateUser(UserDTO user) throws SQLException {
        String sql = "UPDATE users SET family_name = ?, last_name = ?, family_name_kana = ?, " +
                     "last_name_kana = ?, email = ?, password = ?, gender = ?, postal_code = ?, " +
                     "prefecture = ?, address1 = ?, address2 = ?, authority = ?, updated_at = ? " +
                     "WHERE id = ?";

        boolean isUpdated = false;

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, user.getUserFamilyName());
            ps.setString(2, user.getUserLastName());
            ps.setString(3, user.getUserFamilyNameKana());
            ps.setString(4, user.getUserLastNameKana());
            ps.setString(5, user.getUserMail());
            ps.setString(6, user.getUserPassword()); // ハッシュ化したパスワードを事前にセット
            ps.setString(7, user.getUserGender());
            ps.setString(8, user.getUserPostalCode());
            ps.setString(9, user.getUserPrefecture());
            ps.setString(10, user.getUserAddress1());
            ps.setString(11, user.getUserAddress2());
            ps.setString(12, user.getUserAuthority());
            ps.setInt(14, user.getUserId());

            int result = ps.executeUpdate(); // 戻り値は更新された行数
            if (result > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // エラーログを出力
            throw e; // エラーを上位に投げる
        }
        return isUpdated;
    }

}

