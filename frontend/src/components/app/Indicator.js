import PropTypes from 'prop-types';
import React from 'react';
import cx from 'classnames';
import * as IndicatorState from '../../constants/IndicatorState';

/**
 * @file Indicator is a component that shows the save status to user in form of a save progress
 * line beneath the Header.
 * @module Indicator
 */
const Indicator = ({
  indicator: indicatorParam,
  isDocumentNotSaved,
  error,
  exception,
}) => {
  const copyErrorToClipboard = () => {
    if (!error) return;

    let message = error;
    message += '\n';
    message += `\nLocation: ${window.location.href}`;

    if (exception) {
      if (exception?.attributes) {
        for (const [key, value] of Object.entries(exception.attributes)) {
          message += `\n${key}: ${value}`;
        }
      }
      if (exception?.stackTrace) {
        message += `\nStacktrace: ${exception.stackTrace}`;
      }
      if (exception?.adIssueId) {
        message += `\nAD_Issue_ID: ${exception.adIssueId}`;
      }
    }

    navigator.clipboard.writeText(message);
  };

  const indicator = isDocumentNotSaved ? IndicatorState.ERROR : indicatorParam;

  return (
    <div className="window-indicator-container">
      <div className={cx('bar', indicator)} />
      {indicator === IndicatorState.ERROR && error ? (
        <div className="container-fluid message-bar" title={error}>
          <span className="text">{error}</span>
          <button
            className="copy-button btn btn-meta-outline-secondary"
            onClick={copyErrorToClipboard}
          >
            <i className="meta-icon-duplicate" />
          </button>
        </div>
      ) : (
        <div className="container-fluid message-bar message-bar-empty">
          &nbsp;
        </div>
      )}
    </div>
  );
};

Indicator.propTypes = {
  indicator: PropTypes.string.isRequired,
  isDocumentNotSaved: PropTypes.bool,
  error: PropTypes.string,
  exception: PropTypes.object,
};

export default Indicator;
