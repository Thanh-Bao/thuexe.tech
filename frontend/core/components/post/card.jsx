import { Card, CardContent, Tooltip, Typography, Chip, Stack, IconButton, Divider } from '@mui/material';
import { makeStyles } from '@mui/styles';
import Link from 'next/link';
import React, { useState } from 'react';
import ShowMore from '../showMore';
import GalleryPostMedia from '../gallery/postMedia';
import { PhotoLibrary, ModeComment } from '@mui/icons-material';
import { roundToNearest5 } from '@/helper/roundNumber';
import PostUserCard from './userCard';

const useStyles = makeStyles((theme) => ({
    media: {
        height: '100%',
        maxHeight: '140px',
        width: 'auto',
        margin: 'auto'
    },
    postLink: {
        color: "inherit",
        textDecoration: 'none'
    },
    wrapperHeader: {
        padding: '12px'
    },
    contentWrapper: {
        backgroundColor: theme.article.contentWrapper.bgColor,
        border: "1.5px solid #d4d4d4",
        "&:hover": {
            boxShadow: "#acaeb0 3px 8px 15px",
        }
    },
    subheaderUserCard: {
        ...theme.subheaderUserCard,
        textDecoration: 'none',
    },
    content: {
        padding: '0 12px'
    },
    mediaCounter: {
        padding: '0 16px 12px',
    },
    mediaCount: {
        color: theme.typography.body2.color,
        backgroundColor: theme.palette.primary.main,
    },
    mediaWrapper: {
        margin: 0
    },
    linkPost: theme.linkPost,
    actionPostWrapper: {

    },
    actionPostItem: {
        textAlign: 'center',
    },
    chipStats: {
        backgroundColor: 'transparent'
    },
    dividerAction: {
        borderColor: '#eaebed45'
    },
}));

const PostCard = (props) => {
    const classes = useStyles();

    const { _id, media, content, react, userSave, comment } = props.post;

    return (
        <Card className={classes.contentWrapper}>
            <PostUserCard post={props.post} />

            <Stack spacing={1}>
                <GalleryPostMedia media={media} maximage={4} className={classes.mediaWrapper} />

                <CardContent className={classes.content}>
                    <ShowMore>
                        <Typography variant="body2" fontSize={'14px'} component="p">
                            {content}
                        </Typography>
                    </ShowMore>
                </CardContent>

                <Stack spacing={1} className={classes.content}>
                    <Divider />

                    <Stack className={classes.iconAction} spacing={1} direction="row" justifyContent="space-between" alignItems="center">
                        
                    </Stack>
                </Stack>
            </Stack>
        </Card>
    );
}

export default PostCard;