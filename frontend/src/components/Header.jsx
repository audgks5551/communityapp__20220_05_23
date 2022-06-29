import * as React from 'react';

import Box from '@mui/material/Box';

import UserService from "../libs/UserService";

const Header = () => {
    const onClickLogin = () => UserService.doLogin()
    const onClickLogout = () => UserService.doLogout()
    const onClickSignup = () => UserService.doSignup();
    const nickName = UserService.isLoggedIn() && UserService.getNickName()

    return (
        <>
            <Box
            sx={{
                width:  320,
                left:   0,
                top: 0,
                bottom: 0,
                minHeight: '100vh',
                position: 'fixed',
                backgroundColor: 'primary.dark',
            }}
            />
        </>
    );
}

export default Header;