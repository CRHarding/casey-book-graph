import React from 'react';
import { ApolloProvider, Query, Mutation } from 'react-apollo';
import ApolloClient from 'apollo-boost';
import { HttpLink } from 'apollo-link-http';
import gql from 'graphql-tag';

import PostForm from './components/Partials/FormPartials/PostForm';
import SignupForm from './components/Partials/FormPartials/SignupForm';
import Posts from './components/Posts/AllPosts';
import AllUsers from './components/Users/AllUsers';
import EditUserForm from './components/Partials/FormPartials/EditUserForm';

import Grid from '@material-ui/core/Grid';

const client = new ApolloClient({
  uri: 'http://localhost:8080/users-api/graphql',
});

const USERS = gql`
  {
    findAllUsers {
      username
      posts {
        title
        postText
      }
    }
  }
`;

const CREATE_USER = gql`
  mutation createUser($user: InputCreateOneUser!) {
    createUser(input: $user) {
      username
      firstName
      lastName
      email
      aboutMe
      password
    }
  }
`;

const UPDATE_USER = gql`
  mutation updateUser($user: UpdateUserInput!) {
    updateUser(input: $user) {
      id
      username
      firstName
      lastName
      email
      aboutMe
      password
    }
  }
`;

const DELETE_USER = gql`
  mutation deleteUser($id: InputDeleteOneUser) {
    deleteUser(input: $id) {
      username
    }
  }
`;

const CREATE_POST = gql`
  mutation CreatePost($post: CreatePostInput!) {
    createPost(input: $post) {
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
                createPost={({ title, postText }) =>
                  createPost({
                    variables: {
                      post: {
                        title,
                        postText,
                        numberOfLikes: 0,
                        numberOfComments: 0,
                        ableToView: 0,
                        poster: 1,
                      },
                    },
                    refetchQueries: [{ query: USERS }],
                  })
                }
              />
            )}
          </Mutation>
          <Mutation mutation={UPDATE_USER}>
            {updateUser => (
              <EditUserForm
                user={this.state.user}
                updateUser={({
                  id,
                  username,
                  firstName,
                  lastName,
                  email,
                  aboutMe,
                  password,
                }) =>
                  updateUser({
                    variables: {
                      user: {
                        id,
                        username,
                        firstName,
                        lastName,
                        email,
                        aboutMe,
                        password,
                      },
                    },
                    refetchQueries: [{ query: USERS }],
                  })
                }
              />
            )}
          </Mutation>
          <Query query={USERS}>
            {({ loading, error, data }) => {
              if (error) {
                return <div>Error : (</div>;
              }

              if (loading) {
                return <div>Loading...</div>;
              }

              if (!error && !loading) {
                return <AllUsers users={data.findAllUsers} />;
              }
            }}
          </Query>
          <Posts posts={this.state.posts} />
        </Grid>
      </ApolloProvider>
    );
  }
}

export default App;
