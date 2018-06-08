import React, { Component } from 'react';
import UserPosts from './UserPosts';
import Grid from '@material-ui/core/Grid';

class AllPosts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: this.props.user.posts,
      postDataLoaded: false,
      user: this.props.user,
      friend: this.props.friend,
    };
  }

  render() {
    const isUser = this.state.user.id === this.state.friend.id;
    const posts = this.state.posts;
    return (
      <Grid item xs>
        <UserPosts
          posts={posts}
          user={this.state.user}
          friend={this.state.friend}
          isUser={isUser}
          manageDelete={this.props.manageDelete}
          manageEdit={this.props.manageEdit}
        />
      </Grid>
    );
  }
}

export default AllPosts;
