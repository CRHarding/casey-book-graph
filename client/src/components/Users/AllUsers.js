import React, { Component } from 'react';

export default class AllUsers extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userDataLoaded: false,
    };
  }

  renderUsers() {
    return <div />;
  }

  render() {
    const users = this.props.users;
    return (
      <div>
        {users.map((user, key) => {
          return (
            <div key={key}>
              <p>
                {user.username}: {user.firstName}: {user.password}
              </p>{' '}
              <p>{user.aboutMe}</p>
              {user.posts
                ? user.posts.map((post, key) => {
                    return (
                      <p key={key}>
                        {post.title}
                        {post.postText}
                      </p>
                    );
                  })
                : ''}
            </div>
          );
        })}{' '}
      </div>
    );
  }
}
