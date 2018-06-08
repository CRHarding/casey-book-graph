import React, { Component } from 'react';
import SingleFriend from './SingleFriend';
import Grid from '@material-ui/core/Grid';

class SentFriendRequests extends Component {
  state = {
    sentRequest: this.props.sentRequest,
    user: this.props.user,
  };

  render() {
    return (
      <Grid item xs>
        {this.state.sentRequest.map((friend, key) => {
          if (friend) {
            return (
                <SingleFriend friend={friend} key={key} user={this.state.user} />
              );
          } else {
            return null;
          }
        })}
      </Grid>
    );
  }
}

export default SentFriendRequests;
