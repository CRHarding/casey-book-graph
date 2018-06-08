import React, { Component } from 'react';

import SingleFriend from './SingleFriend';
import RenderCurrentFriends from '../Partials/RenderPartials/RenderCurrentFriends';
import FriendServices from '../../services/FriendServices';

import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Typeography from '@material-ui/core/Typography';
import AppBar from '@material-ui/core/AppBar';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';

function TabContainer(props) {
  return (
    <Typeography component="div" style={{ padding: 8 * 3 }}>
      {props.children}
    </Typeography>
  );
}

const styles = theme => ({
  title: {
    marginBottom: 16,
    fontSize: 14,
  },
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
});

class AllFriends extends Component {
  constructor(props) {
    super(props);
    this.state = {
      pendingFriends: null,
      currentFriends: null,
      rejectedFriends: null,
      pendingFriendsDataLoaded: false,
      currentFriendsDataLoaded: false,
      user: this.props.user,
      friend: this.props.friend,
      isUser: this.props.isUser,
      value: 0,
    };

    this.handleFriendChoice = this.handleFriendChoice.bind(this);
  }

  handleChange = (event, value) => {
    this.setState({ value });
  };

  componentDidMount() {
    let currentFriends = [];
    let pendingFriends = [];
    let rejectedFriends = [];

    this.state.user.receivedRequest.filter(friend => {
      if (friend.status === 2) {
        currentFriends.push(friend);
      } else if (friend.status === 1) {
        pendingFriends.push(friend);
      } else {
        rejectedFriends.push(friend);
      }
    });

    this.setState({
      pendingFriends: pendingFriends,
      currentFriends: currentFriends,
      rejectedFriends: rejectedFriends,
      currentFriendsDataLoaded: true,
      pendingFriendsDataLoaded: true,
    });
  }

  handleFriendChoice(friend, choice) {
    console.log(friend, choice);
    let changeFriend = friend;
    if (choice) {
      changeFriend.status = 2;
    } else {
      changeFriend.status = 3;
    }

    if (friend.friendSentRequest.receivedRequest.length > 0) {
      friend.friendSentRequest.receivedRequest = [];
    }

    FriendServices.editFriend(changeFriend)
      .then(responseFriend => {
        let pendingFriends = this.state.pendingFriends;
        let currentFriends = this.state.currentFriends;
        let rejectedFriends = this.state.rejectedFriends;
        pendingFriends = pendingFriends.filter(removeFriend => {
          if (friend !== removeFriend) {
            return removeFriend;
          } else {
            return null;
          }
        });

        if (choice === 2) {
          currentFriends.push(friend);
        } else {
          rejectedFriends.push(friend);
        }

        this.setState({
          pendingFriends: pendingFriends,
          currentFriends: currentFriends,
        });
      })
      .catch(err => {
        console.log('error in updating friend---', err);
      });
  }

  renderPendingFriends() {
    return (
      <TabContainer>
        {this.state.pendingFriends.map((friend, key) => {
          if (friend) {
            return (
              <SingleFriend
                friend={friend}
                user={this.state.user}
                key={key}
                handleFriendChoice={this.handleFriendChoice}
              />
            );
          } else {
            return null;
          }
        })}
      </TabContainer>
    );
  }

  renderCurrentFriends(classes) {
    return (
      <TabContainer>
        {this.state.currentFriends.map((friend, key) => {
          if (friend) {
            return (
              <RenderCurrentFriends
                key={key}
                friend={friend}
                classes={classes}
                isUser={this.state.isUser}
                user={this.state.user}
              />
            );
          } else {
            return null;
          }
        })}
      </TabContainer>
    );
  }

  render() {
    const { classes } = this.props;
    const { value } = this.state;
    return (
      <Grid item xs>
        {this.state.pendingFriendsDataLoaded &&
          this.state.currentFriendsDataLoaded && (
            <div className={classes.root}>
              <AppBar position="static">
                <Tabs value={value} onChange={this.handleChange}>
                  <Tab label="Current Friends" />
                  {this.state.isUser && <Tab label="Pending Friends" />}
                </Tabs>
              </AppBar>
              {value === 0 && this.renderCurrentFriends(classes)}
              <Grid item xs>
                {value === 1 && this.renderPendingFriends(classes)}
              </Grid>
            </div>
          )}
      </Grid>
    );
  }
}

export default withStyles(styles)(AllFriends);
