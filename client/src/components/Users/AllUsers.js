import React, { Component } from 'react';
import UserServices from '../../services/UserServices';

export default class AllUsers extends Component {
  constructor(props) {
    super(props);
    this.state = {
      users: props.users,
      userDataLoaded: false,
    };
  }

  renderUsers() {
    return <div />;
  }

  render() {
    const users = this.state.users;
    console.log(users);
    return (
      <div>
        {users.map((user, key) => {
          return <p>{user.username}: {user.firstName}: {user.password}: {user.aboutMe}</p>;
        })}{' '}
      </div>
    );
  }
}
