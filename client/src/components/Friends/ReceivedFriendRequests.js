import React, { Component } from 'react';
import SingleFriend from './SingleFriend';
import Grid from '@material-ui/core/Grid';

class ReceivedFriendRequests extends Component {
  constructor(props) {
    super(props);
    this.state = {
      receivedRequest: this.props.receivedRequest,
      user: this.props.user,
    };
  }

  render() {
    if (this.state.receivedRequest) {
      return (
        <Grid item xs>
          {this.state.receivedRequest.map((friend, key) => {
            if (friend) {
              return (
                  <SingleFriend
                    friend={friend}
                    user={this.state.user}
                    key={key}
                  />
              );
            } else {
              return null;
            }
          })}
        </Grid>
      );
    }
  }

}

export default ReceivedFriendRequests;
