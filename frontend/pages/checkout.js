import React from 'react';
import Head from '@/layout/web/head';
import WebLayout from '@/layout/web';
import { makeStyles } from '@mui/styles';
// import clsx from 'clsx';

const useStyles = makeStyles((theme) => ({
    helloWorld: {
        backgroundColor: 'red'
    },
    helloWorld2: {
        color: 'blue'
    }
}));

const Checkout = () => {
    const classes = useStyles();
    return (
        <>
            <Head
                title="checkout"
            />
            <WebLayout>
                <div
                    className={`${classes.helloWorld} ${classes.helloWorld2}`}
                >
                    Hello World
                </div>
            </WebLayout>

        </>
    )
}

export default Checkout;
