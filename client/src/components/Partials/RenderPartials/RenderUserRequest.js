import React from 'react';
import Card from '@material-ui/core/Card';
import { withStyles } from '@material-ui/core/styles';

const renderUserRequest = props => {
  const request = props.requests;
  const user = props.user;
  console.log(request);

  return (
    <Card className={this.getCard()}>
      {request.map((friend, key) => {
        if (friend) {
          return (
            <SingleFriend friend={friend} key={key} user={user} />
          );
        } else {
          return null;
        }
      })}
    </Card>
  );
};

export default withStyles(styles)(renderUserRequest);
