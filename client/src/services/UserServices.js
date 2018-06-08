import axios from 'axios';

const UserServices = {
  getAllUsers() {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + '/users',
    });
  },

  getOneUser(userId) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/users/${userId}`,
    });
  },

  getUserByUsername(username) {
    console.log(process.env.REACT_APP_HOST);
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/users/username/${username}`,
    });
  },

  addUser(user) {
    return axios({
      method: 'POST',
      url: process.env.REACT_APP_HOST + '/users',
      data: user,
    });
  },

  editUser(user) {
    return axios({
      method: 'PUT',
      url: process.env.REACT_APP_HOST + '/users/edit',
      data: user,
    });
  },

  deleteUser(user) {
    return axios({
      method: 'DELETE',
      url: process.env.REACT_APP_HOST + '/users/delete',
      data: user,
    });
  },
};

export default UserServices;
