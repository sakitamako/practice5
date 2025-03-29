package com.diworksdev.practice5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.practice5.dto.UserDTO;
import com.diworksdev.practice5.util.DBConnector;

public class UserDAO {
    private DBConnector dbConnector = new DBConnector();

    public UserDTO getUserById(int userId) throws SQLException {
        UserDTO user = null;
        String sql = "SELECT * FROM login_user_transaction WHERE id = ? AND delete_flag = 0";

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user = new UserDTO();
                user.setUserId(rs.getInt("id"));
                user.setUserFamilyName(rs.getString("family_name"));
                user.setUserLastName(rs.getString("last_name"));
                user.setUserFamilyNameKana(rs.getString("family_name_kana"));
                user.setUserLastNameKana(rs.getString("last_name_kana"));
                user.setUserMail(rs.getString("mail"));
                user.setUserGender(rs.getString("gender"));
                user.setUserPostalCode(rs.getString("postal_code"));
                user.setUserPrefecture(rs.getString("prefecture"));
                user.setUserAddress1(rs.getString("address_1"));
                user.setUserAddress2(rs.getString("address_2"));
                user.setUserAuthority(rs.getString("authority"));
                user.setPasswordLength(rs.getInt("password_length")); // 追加
            }
        }
        return user;
    }


    // 更新処理
    public boolean updateUser(UserDTO userDTO) throws SQLException {
        String sql = "UPDATE login_user_transaction SET family_name = ?, last_name = ?, family_name_kana = ?, "
                + "last_name_kana = ?, mail = ?, password = ?, gender = ?, postal_code = ?, prefecture = ?, "
                + "address_1 = ?, address_2 = ?, authority = ?, update_time = NOW() WHERE id = ? AND delete_flag = 0";

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userDTO.getUserFamilyName());
            preparedStatement.setString(2, userDTO.getUserLastName());
            preparedStatement.setString(3, userDTO.getUserFamilyNameKana());
            preparedStatement.setString(4, userDTO.getUserLastNameKana());
            preparedStatement.setString(5, userDTO.getUserMail());

            // パスワードが null または空の場合は更新しない
            if (userDTO.getUserPassword() != null && !userDTO.getUserPassword().isEmpty()) {
                preparedStatement.setString(6, userDTO.getUserPassword());
            } else {
                preparedStatement.setString(6, getUserById(userDTO.getUserId()).getUserPassword());
            }

            preparedStatement.setString(7, userDTO.getUserGender());
            preparedStatement.setString(8, userDTO.getUserPostalCode());
            preparedStatement.setString(9, userDTO.getUserPrefecture());
            preparedStatement.setString(10, userDTO.getUserAddress1());
            preparedStatement.setString(11, userDTO.getUserAddress2());
            preparedStatement.setString(12, userDTO.getUserAuthority());
            preparedStatement.setInt(13, userDTO.getUserId());

            return preparedStatement.executeUpdate() > 0;
        }
    }

    // ユーザー削除処理
    public boolean deleteUser(String userId) {
        String sql = "DELETE FROM login_user_transaction WHERE id = ?";

        try (Connection connection = dbConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userId);
            int result = preparedStatement.executeUpdate();

            return result > 0; // 1 以上なら削除成功
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}