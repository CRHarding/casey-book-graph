import React, { Component } from 'react';

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';

import UserServices from '../../../services/UserServices';

const styles = theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 200,
  },
  menu: {
    width: 200,
  },
});

class UserFormPartial extends Component {
  constructor(props) {
    super(props);
    this.state = {
      userName: '',
      firstName: '',
      lastName: '',
      email: '',
      aboutMe: '',
      pristine: true,
      submitting: false,
    };
  }

  //look up memoize-one for a way to keep track of state
  //change in this component...link-->
  //https://reactjs.org/blog/2018/06/07/you-probably-dont-need-derived-state.html#what-about-memoization

  render() {
    const { classes } = this.props;
    return (
      <form onSubmit={this.handleSubmit}>
        <div>
          <TextField
            id="userName"
            label="User Name"
            className={classes.textField}
            value={this.state.userName}
            margin="normal"
            onChange={this.props.handleChange('userName')}
          />
        </div>
        <div>
          <TextField
            id="firstName"
            label="First Name"
            className={classes.textField}
            value={this.state.firstName}
            margin="normal"
            onChange={this.props.handleChange('firstName')}
          />
        </div>
        <div>
          <TextField
            id="lastName"
            label="Last Name"
            className={classes.textField}
            value={this.state.lastName}
            margin="normal"
            onChange={this.props.handleChange('lastName')}
          />
        </div>
        <div>
          <TextField
            id="email"
            label="Email"
            className={classes.textField}
            value={this.state.email}
            margin="normal"
            onChange={this.props.handleChange('email')}
          />
        </div>
        <div>
          <TextField
            id="textarea"
            label="About Me"
            multiline
            className={classes.textField}
            margin="normal"
            onChange={this.props.handleChange('aboutMe')}
          />
        </div>
      </form>
    );
  }
}

export default withStyles(styles)(UserFormPartial);
