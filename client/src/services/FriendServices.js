import axios from 'axios';

const FriendServices = {
  getAllFriends() {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + '/api/friends',
    });
  },

  getFriendsById(id) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/friends/user/${id}`,
    });
  },

  getOneFriend(friendId) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/friends/${friendId}`,
    });
  },

  getFriendsByStatus(status, id) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/friends/current/${id}/${status}`,
    });
  },

  getFriendsBySentRequest(id) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/friends/sent/${id}`,
    });
  },

  getFriendsByReceivedRequest(id) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/friends/received/${id}`,
    });
  },

  getCurrentUserFriendsById(id) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/friends/current/${id}`,
    });
  },

  addFriend(friend) {
    return axios({
      method: 'POST',
      url: process.env.REACT_APP_HOST + '/api/friends',
      data: friend,
    });
  },

  editFriend(friend) {
    console.log(friend);
    return axios({
      method: 'PUT',
      url: process.env.REACT_APP_HOST + `/api/friends/${friend.id}`,
      data: friend,
    });
  },

  deleteFriend(friend) {
    return axios({
      method: 'DELETE',
      url: process.env.REACT_APP_HOST + '/api/friends/delete',
      data: friend,
    });
  },
};

export default FriendServices;
