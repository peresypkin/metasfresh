import PropTypes from 'prop-types';
import React, { PureComponent } from 'react';
import { connect } from 'react-redux';

import { getView, viewState } from '../reducers/viewHandler';
import {
  setRawModalDescription,
  setRawModalTitle,
} from '../actions/WindowActions';

import DocumentList from '../containers/DocumentList';
import ErrorScreen from './app/ErrorScreen';
import SpinnerOverlay from './app/SpinnerOverlay';
import Modal from './app/Modal';
import RawModal from './app/RawModal';
import Header from './header/Header';
import { computeSaveStatusFlags } from '../reducers/windowHandler';

/**
 * @file Class based component.
 * @module Container
 * @extends Component
 */
class Container extends PureComponent {
  render() {
    const {
      docNoData,
      docId,
      processStatus,
      dataId,
      windowId,
      breadcrumb,
      references,
      actions,
      showSidelist,
      siteName,
      showSpinner, // indicator flag to show spinner while fetching data for the advanced search
      connectionErrorType,
      noMargin,
      entity,
      children,
      viewId,
      attachments,
      modalHidden,
      hideHeader,
      dropzoneFocused,
      notFound,
      rawModal,
      modal,
      pluginModal,
      includedView,
      closeModalCallback,
      editmode,
      handleEditModeToggle,
      masterDocumentList,
      pluginComponents,
      setRawModalTitle,
      setRawModalDescription,
      hasComments,
    } = this.props;
    const pluginModalVisible = pluginModal.visible;
    let PluginModalComponent = null;

    if (pluginModalVisible) {
      // check if pluginModal's component is saved in the redux state
      const modalPluginName = pluginComponents[pluginModal.id];

      if (modalPluginName) {
        // get the plugin holding the required component
        const parentPlugin =
          window.META_HOST_APP.getRegistry().getEntry(modalPluginName);

        PluginModalComponent = parentPlugin.components.filter(
          (component) => component.id === pluginModal.id
        )[0].component;
      }
    }

    return (
      <div>
        {!hideHeader && (
          // Forcing refresh component
          <Header
            windowId={windowId}
            showIndicator={modalHidden}
            {...{
              entity,
              docNoData,
              viewId,
              siteName,
              showSidelist,
              attachments,
              actions,
              references,
              breadcrumb,
              dataId,
              dropzoneFocused,
              notFound,
              docId,
              editmode,
              handleEditModeToggle,
              hasComments,
            }}
          />
        )}

        {/* error type display */}
        {connectionErrorType && <ErrorScreen errorType={connectionErrorType} />}

        {showSpinner && <SpinnerOverlay iconSize={100} spinnerType="modal" />}

        <div
          className={
            'header-sticky-distance js-unselect panel-vertical-scroll ' +
            (noMargin ? 'dashboard' : 'container-fluid')
          }
        >
          {!modalHidden && (
            <Modal
              {...modal}
              windowId={modal.windowId}
              dataId={modal.dataId ? modal.dataId : dataId}
              modalTitle={modal.title}
              viewId={modal.viewId}
              documentType={windowId}
              rawModalWindowId={rawModal.windowId}
              parentDataId={dataId}
              parentViewId={viewId}
              rawModalVisible={rawModal.visible}
              modalViewDocumentIds={modal.viewDocumentIds}
              closeCallback={closeModalCallback}
              modalSaveStatus={
                computeSaveStatusFlags({
                  modal,
                  considerSavedWhenUnknownStatus: true,
                }).isDocumentSaved
              }
            />
          )}

          {rawModal.visible && (
            <RawModal
              modalTitle={rawModal.title}
              modalDescription={rawModal.description}
              allowedCloseActions={rawModal.allowedCloseActions}
              windowId={rawModal.windowId}
              viewId={rawModal.viewId}
              masterDocumentList={masterDocumentList}
              parentWindowId={modal.parentWindowId} // parentWindowId, parentDocumentId, parentFieldId were added to
              parentDocumentId={modal.parentDocumentId} // support the Search feature
              parentFieldId={modal.parentFieldId}
              featureType={modal.dataId} // 'SEARCH'
            >
              <div className="document-lists-wrapper">
                <DocumentList
                  type="grid"
                  windowId={rawModal.windowId}
                  defaultViewId={rawModal.viewId}
                  viewProfileId={rawModal.profileId}
                  setModalTitle={setRawModalTitle}
                  setModalDescription={setRawModalDescription}
                  modalDescription={rawModal.description}
                  isModal
                  processStatus={processStatus}
                  includedView={includedView}
                  inBackground={
                    includedView && includedView.windowId && includedView.viewId
                  }
                  inModal={modal.visible}
                  featureType={modal.dataId} // pass along this type to be able to know down below -> at table level if we need to disable or not
                  // the multi selection depending on the feature type rendered  - as it happens in the `SEARCH` feat)
                />

                {includedView &&
                  includedView.windowId &&
                  includedView.viewId && (
                    <DocumentList
                      type="includedView"
                      windowId={includedView.windowId}
                      viewProfileId={includedView.viewProfileId}
                      defaultViewId={includedView.viewId}
                      parentDefaultViewId={rawModal.viewId}
                      parentWindowType={rawModal.windowId}
                      isModal
                      isIncluded
                      processStatus={processStatus}
                      inBackground={false}
                      inModal={modal.visible}
                    />
                  )}
              </div>
            </RawModal>
          )}

          {pluginModalVisible && (
            <PluginModalComponent
              docId={docId}
              windowId={windowId}
              dataId={dataId}
              entity={entity}
              viewId={viewId}
            />
          )}

          {children}
        </div>
      </div>
    );
  }
}

Container.propTypes = {
  actions: PropTypes.any,
  attachments: PropTypes.any,
  breadcrumb: PropTypes.any,
  children: PropTypes.any,
  closeModalCallback: PropTypes.any,
  connectionErrorType: PropTypes.string,
  dataId: PropTypes.any,
  docId: PropTypes.any,
  docNoData: PropTypes.any,
  dropzoneFocused: PropTypes.any,
  editmode: PropTypes.any,
  entity: PropTypes.any,
  hideHeader: PropTypes.any,
  handleEditModeToggle: PropTypes.any,
  includedView: PropTypes.any,
  masterDocumentList: PropTypes.any,
  modal: PropTypes.any,
  modalDescription: PropTypes.string,
  modalTitle: PropTypes.string,
  noMargin: PropTypes.any,
  notFound: PropTypes.bool,
  pluginModal: PropTypes.object,
  pluginComponents: PropTypes.any,
  processStatus: PropTypes.any,
  viewId: PropTypes.string,
  rawModal: PropTypes.any,
  references: PropTypes.any,
  modalHidden: PropTypes.any,
  showSidelist: PropTypes.any,
  siteName: PropTypes.any,
  setRawModalDescription: PropTypes.any,
  setRawModalTitle: PropTypes.any,
  windowId: PropTypes.string,
  hasComments: PropTypes.bool,
  showSpinner: PropTypes.bool,
};

const mapStateToProps = (state, { windowId }) => {
  let master = getView(state, windowId);

  if (!master || !windowId) {
    master = viewState;
  }

  return {
    notFound: master.notFound,
    connectionErrorType: state.appHandler.connectionErrorType || '',
    showSpinner: state.windowHandler.showSpinner || false,
    pluginComponents: state.pluginsHandler.components,
    pluginModal: state.windowHandler.pluginModal,
    breadcrumb: state.menuHandler.breadcrumb,
  };
};

export default connect(mapStateToProps, {
  setRawModalTitle,
  setRawModalDescription,
})(Container);
