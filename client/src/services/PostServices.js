import axios from 'axios';

const PostServices = {
  getAllPosts() {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + '/api/posts',
    });
  },

  getOnePost(postId) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/posts/${postId}`,
    });
  },

  getPostsByUserId(userId) {
    return axios({
      method: 'GET',
      url: process.env.REACT_APP_HOST + `/api/posts/user/${userId}`,
    });
  },

  addPost(post, userId) {
    return axios({
      method: 'POST',
      url: process.env.REACT_APP_HOST + `/api/${userId}/posts`,
      data: post,
    });
  },

  editPost(post) {
    console.log(post);
    return axios({
      method: 'PUT',
      url: process.env.REACT_APP_HOST + `/api/posts/${post.id}`,
      data: post,
    });
  },

  deletePost(post) {
    return axios({
      method: 'DELETE',
      url: process.env.REACT_APP_HOST + `/api/posts/${post}`,
    });
  },
};

export default PostServices;
