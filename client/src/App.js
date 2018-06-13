// import React, { Component } from 'react';
// import './App.css';
// import Home from './components/Home';
// import UserProfile from './components/UserProfile';
// import { BrowserRouter as Router, Route } from 'react-router-dom';
//
// require('dotenv').config();
//
// class App extends Component {
//   render() {
//     return (
//       <Router>
//         <div>
//           <Route exact path = "/" component = {Home} />
//           <Route exact path = "/users/:id" component = {UserProfile} />
//         </div>
//       </Router>
//     );
//   }
// }
//
// export default App;

import React from 'react';
import ReactDOM from 'react-dom';
import { ApolloProvider, Query, Mutation } from 'react-apollo';
import ApolloClient from 'apollo-boost';
import gql from 'graphql-tag';

import PostForm from './components/Partials/FormPartials/PostForm';
import SignupForm from './components/Partials/FormPartials/SignupForm';
import Posts from './components/Posts/AllPosts';
import Grid from '@material-ui/core/Grid';

const client = new ApolloClient({
  uri: 'http://localhost:8080/api',
});

const POSTS = gql`
  {
    posts {
      title
      postText
      poster {
        username
      }
    }
  }
`;

const CREATE_USER = gql`
  mutation CreateUser($user: UserCreateInput!) {
    createUser(data: $user) {
      userId
      username
    }
  }
`;

const CREATE_POST = gql`
  mutation CreatePost($post: PostCreateInput!) {
    createPost(data: $post) {
      postId
      title
      postText
    }
  }
`;

class App extends React.Component {
  state = { user: { id: 1 } };

  render() {
    return (
      <ApolloProvider client={client}>
        <Grid>
          <h1>CURRENT USER: {this.state.user.username}</h1>
        <Mutation
            mutation={CREATE_USER}
            update={(cache, { data }) => {
              this.setState({ user: data.createUser });
            }}
          >
            {createUser => (
              <SignupForm
                createUser={({
                  userId,
                  username,
                  firstName,
                  lastName,
                  email,
                  aboutMe,
                  password,
                }) =>
                  createUser({
                    variables: {
                      user: {
                        userId,
                        username,
                        firstName,
                        lastName,
                        email,
                        aboutMe,
                        password,
                      },
                    },
                  })
                }
              />
            )}
          </Mutation>
          <Mutation mutation={CREATE_POST}>
            {createPost => (
              <PostForm
                user={this.state.user}
                createPost={({ postId, title, postText }) =>
                  createPost({
                    variables: {
                      post: {
                        postId,
                        title,
                        postText,
                        poster: { connect: { id: this.state.user.userId } },
                      },
                    },
                    refetchQueries: [{ query: POSTS }],
                  })
                }
              />
            )}
          </Mutation>
          <Query query={POSTS}>
            {({ loading, error, data }) => {
              if (error) {
                return <div>Error : (</div>;
              }

              if (loading) {
                return <div>Loading...</div>;
              }

              return <Posts posts={data.posts} />;
            }}
          </Query>
          <Posts posts={this.state.posts} />
        </Grid>
      </ApolloProvider>
    );
  }
}

export default App;
