import React from 'react';
import PropTypes from 'prop-types';

import { distributionLineScreenLocation } from '../../../routes/distribution';

import ButtonWithIndicator from '../../../components/buttons/ButtonWithIndicator';
import ButtonQuantityProp from '../../../components/buttons/ButtonQuantityProp';
import { useMobileNavigation } from '../../../hooks/useMobileNavigation';

const DistributionLineButton = ({
  testId,
  applicationId,
  wfProcessId,
  activityId,
  lineId,
  caption,
  uom,
  qtyPicked,
  qtyToMove,
  completeStatus,
  isUserEditable,
}) => {
  const history = useMobileNavigation();
  const handleClick = () => {
    history.push(distributionLineScreenLocation({ applicationId, wfProcessId, activityId, lineId }));
  };

  return (
    <ButtonWithIndicator
      testId={testId}
      caption={caption}
      completeStatus={completeStatus}
      disabled={!isUserEditable}
      onClick={handleClick}
    >
      <ButtonQuantityProp qtyCurrent={qtyPicked} qtyTarget={qtyToMove} uom={uom} applicationId="distribution" />
    </ButtonWithIndicator>
  );
};

DistributionLineButton.propTypes = {
  //
  // Props
  testId: PropTypes.string,
  applicationId: PropTypes.string.isRequired,
  wfProcessId: PropTypes.string.isRequired,
  activityId: PropTypes.string.isRequired,
  lineId: PropTypes.string.isRequired,
  caption: PropTypes.string.isRequired,
  isUserEditable: PropTypes.bool.isRequired,
  completeStatus: PropTypes.string.isRequired,
  uom: PropTypes.string.isRequired,
  qtyToMove: PropTypes.number.isRequired,
  qtyPicked: PropTypes.number.isRequired,
};

export default DistributionLineButton;
