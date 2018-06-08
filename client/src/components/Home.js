import React, { Component } from 'react';

import Grid from '@material-ui/core/Grid';
import { withStyles } from '@material-ui/core/styles';
import Divider from '@material-ui/core/Divider';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

import Header from './Partials/Header';
import AllPosts from './Posts/AllPosts';
import AllFriends from './Friends/AllFriends';
import SignupForm from './Partials/FormPartials/SignupForm';
import LoginForm from './Partials/FormPartials/LoginForm';
import PostForm from './Partials/FormPartials/PostForm';

import UserServices from '../services/UserServices';
import PostServices from '../services/PostServices';

const styles = theme => ({
  card: {
    minWidth: 275,
  },
  title: {
    marginBottom: 16,
    fontSize: 14,
  },
  root: theme.mixins.gutters({
    paddingTop: 16,
    paddingBottom: 16,
    marginTop: theme.spacing.unit * 3,
  }),
  button: {
    margin: theme.spacing.unit,
  },
  typography: {
    color: '#FF0000',
  },
});

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      posts: null,
      isUser: true,
      isLoggedIn: false,
      login: true,
      showPostForm: false,
    };

    this.handleSignup = this.handleSignup.bind(this);
    this.handleLoginSubmit = this.handleLoginSubmit.bind(this);
    this.handleLogout = this.handleLogout.bind(this);
    this.handlePostDelete = this.handlePostDelete.bind(this);
    this.handlePostEdit = this.handlePostEdit.bind(this);
    this.handlePostAdd = this.handlePostAdd.bind(this);
    this.showAddPostForm = this.showAddPostForm.bind(this);
  }

  handleSignup() {
    this.setState({
      login: !this.state.login,
    });
  }

  handleLoginSubmit(username) {
    UserServices.getUserByUsername(username)
      .then(user => {
        console.log(user.data);
        if (user.data.id) {
          this.setState({
            user: user.data,
            posts: user.data.posts,
            isLoggedIn: true,
            errors: '',
          });
        } else {
          this.setState({
            errors: 'Invalid credentials, please try again...',
          });
        }
      })
      .catch(err => {
        console.log('error in login form--->', err);
      });
  }

  handleLogout() {
    this.setState({
      user: null,
      isLoggedIn: false,
    });
  }

  handlePostDelete(postId) {
    PostServices.deletePost(postId)
      .then(deletedPost => {
        console.log('post deleted successfully--->', deletedPost);

        let posts = this.state.posts;
        console.log(posts);
        posts = posts.filter(post => post.id !== postId);
        console.log(posts);

        let user = this.state.user;
        user.posts = posts;
        console.log(user);
        this.setState({
          user: user,
          posts: posts,
        });
      })
      .catch(err => {
        console.log('post delete failed--->', err);
      });
  }

  handlePostEdit(post) {
    PostServices.editPost(post, this.state.user.id)
      .then(editPost => {
        console.log('Editing post worked!--->', editPost.data);
        let toAddEditPosts = this.state.posts.map(onePost => {
          if (onePost.id === editPost.data.id) {
            onePost = editPost.data;
          }
        });

        this.setState({
          post: toAddEditPosts,
        });
      })
      .catch(err => {
        console.log('Error in editing post--->', err);
      });
  }

  handlePostAdd(post) {
    PostServices.addPost(post, this.state.user.id)
      .then(addPost => {
        console.log('Adding post worked!--->', addPost);
        let posts = this.state.posts;
        posts.push(post);
        this.setState({
          posts: posts,
          showPostForm: false,
        });
      })
      .catch(err => {
        console.log('Error in adding post--->', err);
      });
  }

  showAddPostForm() {
    console.log('here');
    this.setState({
      showPostForm: !this.state.showPostForm,
    });
  }

  render() {
    const { classes } = this.props;

    return (
      <Grid className={classes.root}>
        <Header
          user={this.state.user}
          isLoggedIn={this.state.isLoggedIn}
          handleLogout={this.handleLogout}
        />
        {this.state.errors ? (
          <Typography id="error" label="Error" className={classes.typography}>
            {this.state.errors}
          </Typography>
        ) : (
          ''
        )}
        {this.state.isLoggedIn ? (
          <Grid>
            <Grid container spacing={24}>
              <AllFriends
                user={this.state.user}
                friend={this.state.user}
                isUser={this.state.isUser}
              />
              <AllPosts
                user={this.state.user}
                friend={this.state.user}
                isUser={this.state.isUser}
                manageDelete={this.handlePostDelete}
                manageEdit={this.handlePostEdit}
              />
            </Grid>
            {this.state.showPostForm ? (
              <PostForm
                handlePostAdd={this.handlePostAdd}
                user={this.state.user}
              />
            ) : (
              <Button onClick={this.showAddPostForm}>Add Post!</Button>
            )}
          </Grid>
        ) : (
          <Grid>
            <Divider />
            <Divider />
            {this.state.login ? (
              <LoginForm handleLoginSubmit={this.handleLoginSubmit} />
            ) : (
              <SignupForm />
            )}
            <Button type="submit" onClick={this.handleSignup}>
              {this.state.login ? 'New User?' : 'Returning User?'}
            </Button>
          </Grid>
        )}
      </Grid>
    );
  }
}

export default withStyles(styles)(Home);
